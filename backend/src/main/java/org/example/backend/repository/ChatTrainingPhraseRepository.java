package org.example.backend.repository;

import org.example.backend.entity.child.chatbot.ChatTrainingPhrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatTrainingPhraseRepository extends JpaRepository<ChatTrainingPhrase, Long> {
    List<ChatTrainingPhrase> findByIntentId(Long intentId);

    List<ChatTrainingPhrase> findByIsProcessedFalse();

    Optional<ChatTrainingPhrase> findByPhraseText(String phraseText);

    @Query("SELECT p FROM ChatTrainingPhrase p WHERE p.isProcessed = false ORDER BY p.frequency DESC, p.createdAt DESC LIMIT :limit")
    List<ChatTrainingPhrase> findTopUnprocessedPhrases(@Param("limit") int limit);

    @Query("SELECT p FROM ChatTrainingPhrase p WHERE p.intent.id = :intentId ORDER BY p.frequency DESC LIMIT :limit")
    List<ChatTrainingPhrase> findTopByIntentIdOrderByFrequencyDesc(@Param("intentId") Long intentId, @Param("limit") int limit);
}