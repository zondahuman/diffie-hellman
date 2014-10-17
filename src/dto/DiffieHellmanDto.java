package dto;

import java.math.BigInteger;
import java.util.Random;

import math.Primalidade;

public class DiffieHellmanDto {
	private BigInteger privateKey;
	private PublicInfoDto publicInfoDto;

	public DiffieHellmanDto() {
		BigInteger prime = Primalidade.genPrimo(100);
		this.privateKey = new BigInteger(prime.bitLength(), new Random());
		this.publicInfoDto = new PublicInfoDto(prime, this.privateKey);
	}

	public DiffieHellmanDto(PublicInfoDto publicInfo) {
		BigInteger prime = publicInfo.getPrime();
		this.privateKey = new BigInteger(prime.bitLength(), new Random());
		this.publicInfoDto = new PublicInfoDto(this.privateKey, publicInfo);
	}

	public PublicInfoDto getPublicInfoDto() {
		return this.publicInfoDto;
	}

	public void print() {
		System.out.println("\nMeus Dados:\nChave Privada: " + this.privateKey + "\n");
		this.publicInfoDto.print();
	}
}
