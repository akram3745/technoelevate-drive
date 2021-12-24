package com.technoelevate.uploadform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technoelevate.uploadform.dto.Drive;

public interface DriveRepository extends JpaRepository<Drive, Integer> {

	public Drive findByDriveId(Integer driveId);
}
