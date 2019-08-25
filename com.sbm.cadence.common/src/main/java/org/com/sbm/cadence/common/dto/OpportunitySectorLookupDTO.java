package org.com.sbm.cadence.common.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "opportunity_sector_lookup")
public class OpportunitySectorLookupDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sectorId;
	
	@Column(name = "sector", nullable = false)
	private String sector;

	public OpportunitySectorLookupDTO() {}
	
	public OpportunitySectorLookupDTO(String sector) {
		super();
		this.sector = sector;
	}

	public long getSectorId() {
		return sectorId;
	}

	public void setSectorId(long sectorId) {
		this.sectorId = sectorId;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	@Override
	public String toString() {
		return "OpportunitySectorLookup [sectorId=" + sectorId + ", sector=" + sector + "]";
	}
	
}
