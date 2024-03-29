# PasswordFX 💻

---

## 목차

---

1. [**PasswordFX 소개**](#1)
2. [**PasswordFX 목표**](#2)
3. [**기술 스택**](#3)
4. [**주요 기능**](#4)
5. [**개발 LOG**](#5)
6. [**버전**](#6)
---
<div id="1"></div>

## 📋 PasswordFX 소개

아이디와 비밀번호 관리 프로그램.
아이디와 비밀번호는 데이터베이스에 암호화되어 안전하게 보관할 수 있다.

---
<div id="2"></div>

## 🎯 PasswordFX 목표

사용자가 가입한 여러 사이트의 아이디와 비밀번호를 쉽게 저장하고 관리 할 수 있도록 도움을 줄 수 있다.

---

<div id="3"></div>

## 🔧 기술스택

<a href="https://www.java.com/" target="_blank"><img style="margin: 10px" src="https://profilinator.rishav.dev/skills-assets/java-original-wordmark.svg" alt="Java" height="50" /></a>

Library: JavaFX 19 [ sdk 다운로드 = <https://openjfx.io> ] <br/> Database: H2 <br/> Tool: SceneBuilder <br/>
Launch4j를 이용하여 .exe파일로 배포 시도 중

---

<div id="4"></div>

## 💡 주요 기능

1. 메인 창 -> Register: 프로그램 사용자를 추가하는 기능. 사용자는 Name, Username과 Password로 이루어져 있다. Sign up을 하기 위해서는
프로그램에 등록되지 않은 username을 설정하고 모든 필드가 채워져야 한다. <br/><br/>
2. 로그인 이후 창 -> Add: 각 웹사이트의 name, url, id, password를 입력하고 추가하는 창을 생성한다. 모든 필드는 필수다.<br/><br/>
3. 로그인 이후 창 -> Remove: 사용자가 추가했던 해당 웹사이트의 정보를 삭제한다. <br/><br/>
4. 로그인 이후 창 -> Modify: 사용자가 추가했던 해당 웹사이트의 정보를 수정한다. <br/><br/>
5. 로그인 이후 창 -> Logout: 프로그램을 종료한다.

---

<div id="5"></div>

## 📃 개발 LOG

* 22.12.28 - 프로젝트 시작, 메인 GUI 제작
* 22.12.29 - 로그인 success / fail GUI 제작
* 22.12.30 - 로그인 이후 메인 GUI, Add 팝업 제작
* 22.12.31 - Add 팝업 상세 GUI 제작
* 23.01.02 - Registration GUI 제작, H2 데이터베이스 구축 및 연동
* 23.01.03 - 데이터베이스를 이용한 Main user sign up 기능 제작, login 기능 제작
* 23.01.04 - 데이터베이스를 이용한 Add information 기능 제작
* 23.01.05 - LoggedIn 정보 선택창 기능 제작 -> 사용자가 정보 입력 후 바로 반영되도록 제작. 입력된 정보 클릭 후 그에 대한 내용 출력 기능
제작
* 23.01.07 - 정보 삭제(Remove) 기능 제작, Modify 팝업 GUI 제작
* 23.01.08 - Modify 기능 제작, 모든 기능 제작 완료
* 23.01.08 - **Version 1.0**
* 23.01.16 - 데이터베이스 암호화 완료 - AES-256 알고리즘 적용

---
<div id="1"></div>

## 💾 버전

## V.1.0

[![V.1.0](http://img.youtube.com/vi/Oh_f3jr0kGo/0.jpg)](https://youtu.be/Oh_f3jr0kGo?t=0s)
