package guru.ysy.ragollama.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.List;

/**
 * @Author: Fred R. Zhen
 * @Date: 2024/5/14 16:26
 * @Email: fred.zhen@gmail.com
 */
@Slf4j
@Configuration
public class VectorStoreConfig {

    @Bean
    SimpleVectorStore simpleVectorStore(EmbeddingClient embeddingClient, VectorStoreProperties vectorStoreProperties) {

        var store = new SimpleVectorStore(embeddingClient);
        File vectorStoreFile = new File(vectorStoreProperties.getVectorStorePath());

        if (vectorStoreFile.exists()) {
            store.load(vectorStoreFile);
        } else {
            log.info("Loading documents into vector store...");
            vectorStoreProperties.getDocumentsToLoad().forEach( document -> {
                log.info("Loading document: {}", document.getFilename());
                TikaDocumentReader tikaReader = new TikaDocumentReader(document);
                List<Document> docs = tikaReader.get();
                TextSplitter textSplitter = new TokenTextSplitter();
                List<Document> splitDocs = textSplitter.apply(docs);
                store.add(splitDocs);
            });

            store.save(vectorStoreFile);
        }

        return store;
    }
}
