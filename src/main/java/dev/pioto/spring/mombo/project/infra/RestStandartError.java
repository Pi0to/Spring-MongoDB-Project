package dev.pioto.spring.mombo.project.infra;

import org.springframework.http.HttpStatusCode;

import java.sql.Timestamp;

public record RestStandartError(HttpStatusCode status, String errorMessage, Timestamp timestamp) {
}
