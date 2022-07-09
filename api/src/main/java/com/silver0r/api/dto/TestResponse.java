package com.silver0r.api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestResponse {
	private final String id;
	private final String value;
}
