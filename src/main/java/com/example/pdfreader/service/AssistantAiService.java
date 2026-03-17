package com.example.pdfreader.service;

import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AssistantAiService {

    @SystemMessage("""
            Você é um assistente pessoal que resume textos.
            Responda apenas com o resumo do texto que será enviado para você por meio da aplicação
            
            SOBRE O RESUMO
            - O Resumo deve ser em no Máximo 15 linhas.
            - Formate o texto de forma coerente, retirando qualquer marcação de quebrade linha.
            IMPORTANTE:
            - Não invente nada sobre o texto enviado.
            - Se a pergunta for diferente de algum texto, responda que não pode ajudar
            
            """)
    Result<String> handleRequest(@UserMessage String userMessage);

}
