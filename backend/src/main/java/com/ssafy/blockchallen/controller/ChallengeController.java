package com.ssafy.blockchallen.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.blockchallen.dto.certificationListDTO;
import com.ssafy.blockchallen.dto.createChallengeDTO;
import com.ssafy.blockchallen.dto.detailChallengeDTO;
import com.ssafy.blockchallen.dto.idDTO;
import com.ssafy.blockchallen.dto.myChallengeDTO;
import com.ssafy.blockchallen.dto.resultChallengeDTO;
import com.ssafy.blockchallen.service.IChallengeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/blockchallen")
public class ChallengeController {

	@Autowired
	private IChallengeService challengeService;
	
	@RequestMapping(path = "/challenge", method = RequestMethod.POST)	
	public Object createChallenge(@RequestBody createChallengeDTO challenge) throws IOException {
		
		if(challengeService.createChallenge(challenge)) {
			return new ResponseEntity<>("챌린지 생성 성공", HttpStatus.OK);
		}
		return new ResponseEntity<>("챌린지 생성 실패", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(path = "/challenge", method = RequestMethod.GET)
	public Object datailChallenge(@RequestParam long id) {
		
		detailChallengeDTO challenge = challengeService.detailChallenge(id);
		if(challenge != null)
			return new ResponseEntity<>(challenge, HttpStatus.OK);
		else
			return new ResponseEntity<>("존재하지 않는 챌린지", HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(path = "/challenges", method = RequestMethod.GET)
	public Object getChallenges(@RequestParam String option) {
		return new ResponseEntity<>(challengeService.getChallenges(option),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/mychallenges/{id}", method = RequestMethod.GET)
	public Object myChallenges(@PathVariable("id") long id) throws ParseException {
		
		List<myChallengeDTO> list = challengeService.MyChallenges(id);
		if(list != null)
			return new ResponseEntity<>(list, HttpStatus.OK);
		else
			return new ResponseEntity<>("존재하지 않는 회원", HttpStatus.NO_CONTENT);
			
	}
	
	@RequestMapping(path = "/challenge/certification", method = RequestMethod.GET)
	public Object getCertifications(@RequestParam long id) {

		List<certificationListDTO> list = challengeService.getCertifications(id);
		if(list != null)
			return new ResponseEntity<>(list, HttpStatus.OK);
		else
			return new ResponseEntity<>("존재하지 않는 챌린지", HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(path = "/challenge/result", method = RequestMethod.GET)
	public Object challengeResult(@RequestParam long id) throws ParseException {
		
		resultChallengeDTO result = challengeService.getResult(id);
		if(result != null)
			return new ResponseEntity<>(result, HttpStatus.OK);
		else
			return new ResponseEntity<>("존재하지 않는 챌린지", HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(path = "/participate", method = RequestMethod.POST)
	public Object challengeParticipate(@RequestBody idDTO ids) {
		Object result = challengeService.challengeParticipate(ids); 
		if(result!=null) {
			if((boolean)result)
				return new ResponseEntity<>("챌린지 참여 성공", HttpStatus.OK);
			else
				return new ResponseEntity<>("이미 참여한 챌린지", HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("해당 회원 또는 챌린지를 찾을 수 없음", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(path = "/participate", method = RequestMethod.GET)
	public Object checkParticipate(@RequestParam long uid, @RequestParam long cid) {
		Object result = challengeService.checkParticipate(uid, cid);
		if(result!=null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else
			return new ResponseEntity<>("존재하지 않는 챌린지", HttpStatus.NO_CONTENT);
	}
	
}
