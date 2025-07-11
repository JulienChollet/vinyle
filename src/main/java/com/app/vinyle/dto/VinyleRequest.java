package com.app.vinyle.dto;

import java.util.List;

public record VinyleRequest(String id,  String band,   String name,  List<String>titles, String type, String description) {
}
