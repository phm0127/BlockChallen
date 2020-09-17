package com.ssafy.blockchallen.service.impl;

import com.ssafy.blockchallen.service.IWalletService;
import com.ssafy.blockchallen.dto.walletDTO;
import com.ssafy.blockchallen.entity.Account;
import com.ssafy.blockchallen.entity.Wallet;
import com.ssafy.blockchallen.repository.WalletRepository;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService implements IWalletService {

	@Autowired
	private WalletRepository walletRepository;

	@Override
	public Wallet findById(long id) {
		return walletRepository.findById(id).orElse(null);
	}

//	@Override
//	public Wallet findByWallet(Wallet wallet) {
//		return walletRepository.findByWallet(wallet);
//	}
	
//	@Override
//	public Wallet create(walletDTO wallet, long id) {
//		Wallet newWallet = new Wallet();
//		newWallet.setAccount(id);
//		return walletRepository.save();
//	}
	@Override
	public Wallet syncBalance(String walletAddress, BigDecimal balance, int cash) {
		return null;
	}
	
	@Override
	public Wallet requestEth(String walletAddress) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public Wallet findByAccount(Account account) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public Wallet findByWallet(Wallet address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Wallet create(walletDTO wallet, long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}