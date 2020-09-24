package com.ssafy.blockchallen.service;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import com.ssafy.blockchallen.dto.certificationListDTO;

import com.ssafy.blockchallen.dto.createChallengeDTO;
import com.ssafy.blockchallen.dto.detailChallengeDTO;
import com.ssafy.blockchallen.dto.idDTO;
import com.ssafy.blockchallen.dto.myChallengeDTO;
import com.ssafy.blockchallen.dto.resultChallengeDTO;
import com.ssafy.blockchallen.entity.Challenge;

public interface IChallengeService {
	
	boolean createChallenge(createChallengeDTO challenge);
	detailChallengeDTO detailChallenge(long id);
	List<myChallengeDTO> MyChallenges(long id) throws ParseException;
	Collection<Challenge> getChallenges(String option);
	List<certificationListDTO> getCertifications(long id);
	resultChallengeDTO getResult(long id) throws ParseException;
	Object challengeParticipate(idDTO ids);
	Object checkParticipate(long uid, long cid);
}
