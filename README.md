## 🚀 프로젝트명 
### - GMS(Gym Member Service)

------------------------------------------------

![image](https://github.com/user-attachments/assets/8e204837-170f-4256-bf2c-bea262d64ff9)

---------------------------------------
## 🖥️ 프로젝트 설명

-----------------

- 헬스장 회원관리 프로그램
- 공지 사항과 자유게시판을 통해 정보 소통 가능
- 출석 체크를 통한 회원 관리

------------------------------

## 🕰️개발 기간

----------------------------------

전체 개발 기간 : 2024.04.03 ~ 2024.04.23

---------------------------


## 🔗 ER-DIAGRAM

---------------------
![image](https://github.com/user-attachments/assets/99f0af21-9366-438d-8aba-bc8c57ac9559)


---------------------------

## 💻 기술 스택

-------------
### 작업 툴
![사진](https://camo.githubusercontent.com/92b8740de6bc60cb5d5115586a179c73a9938bb4f8947649ee5f232a3f339ecc/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d3030373339363f7374796c653d666f722d7468652d6261646765266c6f676f3d6a617661266c6f676f436f6c6f723d7768697465)

### 데이터베이스
![사진](https://camo.githubusercontent.com/1295639952a5aaf483c760e6fa22f57c32e10f5488a41097bee2a92e3ccae252/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6d7973716c2d3434373941313f7374796c653d666f722d7468652d6261646765266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465)

------------------------------------

## 기능구현

----------------------------

[로그인/ 회원가입]
- 회원가입 기능구현
- 회원가입 시 작성 했던 정보를 통한 로그인 기능 구현.

[게시판]
- 공지 게시판/ 자유 게시판 변경 기능 구현
- 공지 게시판에서는 관리자 권한이 있어야 작성 및 수정 권한부여 기능 구현
- 자유 게시판에서는 본인이 작성한 글에 한에서만 수정 및 삭제 가능 기능 구현
- 자유 게시판에서는 관리자 권한을 가지고 있을 시 모든 글 삭제 가능 기능 구현

[상담예약]
- 로그인 상태를 확인해 상담예약 페이지 접속 권한부여 기능 구현
- 회원 정보 창을 통해 예약시간 출력 기능 구현
- 예약시 입력했던 비밀번호 확인을 통한 상담 취소 기능 구현
- 예약시 해당 시간 미출력, 취소시 해당 시간 재출력 기능 구현

[헬스장 정보 확인]
- CASE를 이용한 헬스장 정보 확인 기능 구현

[출석 체크]
- 출석체크/ 출석 확인 기능 구현
- 로그인한 사용자외 타 유저 대리 출석 불가능 기능 구현

---------------------------------------------

## 📌 페이지 기능 소개

----------------------

### [메인페이지]
![image](https://github.com/user-attachments/assets/0d04fb39-1131-4ad1-a34a-ee137f54c729)

    - 각 검색어 출력을 통해 원하는 곳으로 이동 가능함.


### [회원가입]
![image](https://github.com/user-attachments/assets/03030864-e289-4952-a427-ec020624c07e) 

    - 회원가입 검색어 입력후 진입이 가능함.
    - 아이디 비밀번호 이름을 통해 회원 가입 가능함.

### [로그인 및 회원 정보]
![image](https://github.com/user-attachments/assets/1409b54c-53b2-4171-8f8e-66deb9e5c17b)

    - 로그인 검색어를 입력후 진입 후 로그인 가능함.
    - 회원 정보 검색어를 입력 하면 현제 본인의 회원 정보 및 상담예약 확인 가능함.


### [공지 게시판]
![image](https://github.com/user-attachments/assets/5ff744bd-f916-4186-9cfc-40eb1f048cbe)
![image](https://github.com/user-attachments/assets/8dd2b360-86f1-4c08-9523-eacb315a3397) 

    - 공지 게시판 검색어 입력후 진입 가능함.
    - 관리자 외 게시글 작성 불가능.

### [자유 게시판] 
![image](https://github.com/user-attachments/assets/3c241c23-a07e-483b-abd8-6bde90083abf) 

    - 게시판 변경 검색어 입력후 자유 게시판 번호를 입력하며 진입 가능.
    - 누구나 게시글 작성가능.
    - 본인이 작성한 게시글 외 타 유저의 게시물은 수정 및 삭제 불가능.
    - 관리자는 모든 게시물 삭제 가능.

### [상담 ]
 #### 예약
![image](https://github.com/user-attachments/assets/42bfaf91-754d-4187-af57-0ec61c502f59) 
 #### 취소
![image](https://github.com/user-attachments/assets/1f7da335-0b50-4a0d-9dec-167da440815e) 

    - 로그인 후 상담 예약 검색어를 통해 진입 가능함.
    - 예약할 시간과 확인 비밀번호를 입력시 상담 예약이 가능함.
    - 예약 확인은 회원 정보 검색어 입력을 통해 확인 가능.
### [헬스장 정보]

![image](https://github.com/user-attachments/assets/38ed8384-d09f-4fdf-9757-465c22a5db27) 

- 헬스장 정보 검색어 입력 후 진입 가능함.
- 헬스장 정보를 확인 가능함.

### [출석]
 #### 출석 체크
![image](https://github.com/user-attachments/assets/2d7faec4-5a42-4393-a3f8-f1f48d94a46a)
 
    - 로그인 후 출석체크 검색어를 통해 진입 가능함.
    - 목록의 본인의 번호를 입력후 출석 체크가 가능함.
![image](https://github.com/user-attachments/assets/45591297-5c70-428d-9a90-ea17428ae9f4)
    - 본인 외 다른 유저 대리 출석 불가능
 #### 출석 확인
![image](https://github.com/user-attachments/assets/101e805f-ed65-44e1-88ce-4d67186e9e09)

    - 출석 확인 검색어 입력후 진입 가능함.
    - 출석 현황을 확인 가능함.