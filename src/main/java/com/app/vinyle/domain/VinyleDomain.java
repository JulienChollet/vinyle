package com.app.vinyle.domain;

import org.springframework.lang.NonNull;

import java.util.List;

public record VinyleDomain(String id, @NonNull String band, @NonNull String name, List<String> titles, String type, String description) {
}