package com.app.vinyle.dto;

import org.springframework.lang.NonNull;

import java.util.List;

public record VinyleRequest(String id, @NonNull String band,  @NonNull String name,  List<String>titles, String type, String description) {
}
