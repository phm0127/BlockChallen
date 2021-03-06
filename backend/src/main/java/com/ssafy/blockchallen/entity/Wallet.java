package com.ssafy.blockchallen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(value="지갑 번호")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "account_id")
	@JsonManagedReference
	@ApiModelProperty(required = true, value="회원 번호")
	private Account account;
	
	@ApiModelProperty(required = true, value="지갑 주소")
	private String address;
	
	public static class Builder {
		private Account account;
		private String address = "";
		
		public Builder() {
			
		}
		public Builder account(Account account) {
			this.account = account;
			return this;
		}
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		public Wallet build() {
			return new Wallet(this);
		}
	}
	private Wallet(Builder builder) {
		account = builder.account;
		address = builder.address;
	}
	
}
