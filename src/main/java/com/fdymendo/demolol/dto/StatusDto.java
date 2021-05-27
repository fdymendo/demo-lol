package com.fdymendo.demolol.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class StatusDto {

	private int id;
	@JsonProperty("maintenance_status")
	private String maintenanceStatus;
	@JsonProperty("incident_severity")
	private String incidentSeverity;
	private List<ContentDto> titles;
	private List<UpdateDto> updates;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("archive_at")
	private String archiveAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	private List<String> platforms;

}