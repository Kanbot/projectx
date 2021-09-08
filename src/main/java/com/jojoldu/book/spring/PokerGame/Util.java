package com.jojoldu.book.spring.PokerGame;

import java.util.Scanner;

public class Util {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 한칸 띄우기
	public void space() {
		System.out.println();
	}
	// 콘솔 창 초기화
	public  void clean() {
		for(int x=0;x<25;x++) {
			System.out.println();

		}
	}
	// x번째 페이즈 안내 문구
	public void piase(int o ,int so) {
		Scanner sc =new Scanner(System.in);
		System.out.println(o+"번째 오픈 페이즈");
		System.out.println("딜러 선");
		System.out.println("새로운 카드를 뽑숩니다.(1 ~9) 입력");
		so =sc.nextInt();
		System.out.println("---새로운 오픈 카드 배분---");
	}
	//알림
	public  void note() {
		System.out.println("------------------------------------------");
		System.out.println("--- 배팅 ---");
		System.out.println("최소 배팅 금액: 100원");
		System.out.println("배팅: 뻥 /따당 /쿼터 /하프 /올인 /체크 /콜 /다이 /레이스");
	}

	//알림1
	public void note1(double bat) {
		System.out.println("------------------------------------------");
		System.out.println("--- 배팅 ---");
		System.out.println("현재 배팅 금액: "+(int)bat +"원");
		System.out.println("배팅: 뻥 /따당 /쿼터 /하프 /올인 /체크 /콜 /다이 /레이스");
	}

}
