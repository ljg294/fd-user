truncate user;

INSERT INTO user(user_id, email, password, name, age, gender, mobile, signup_datetime, delete_yn, created_user_id, created_datetime, modified_user_id, modified_datetime)
VALUES (1, 'user1@gmail.com', 'hashed_password_user1', '홍길동', 20, 'MALE', '010-1234-5678', '2024-01-01', 'N', 0, '2024-01-01 00:00:00', 0, '2024-01-01 00:00:00'),
       (2, 'user2@naver.com', 'hashed_password_user2', '이재규', 30, 'MALE', '010-2222-2222', '2024-01-01', 'N', 0, '2024-01-01 00:00:00', 0, '2024-01-01 00:00:00'),
       (3, 'user3@gmail.com', 'hashed_password_user3', 'Jess', 25, 'FEMALE', '010-3333-3333', '2024-01-01', 'N', 0, '2024-01-01 00:00:00', 0, '2024-01-01 00:00:00'),
       (4, 'user4@naver.com', 'hashed_password_user4', 'Hong', 44, 'FEMALE', '010-4444-4444', '2024-01-01', 'N', 0, '2024-01-01 00:00:00', 0, '2024-01-01 00:00:00'),
       (5, 'user5@gmail.com', 'hashed_password_user5', 'Jay', 55, 'MALE', '010-4444-4444', '2024-01-01', 'N', 0, '2024-01-01 00:00:00', 0, '2024-01-01 00:00:00')
;

COMMIT;