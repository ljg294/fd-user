DROP TABLE IF EXISTS `user`;

#-----------------------------------------------------------------------------------------------------------------------
#-- Table 명 : user (사용자)
#-----------------------------------------------------------------------------------------------------------------------
CREATE TABLE `user`
(
    user_id                           BIGINT                       NOT NULL  AUTO_INCREMENT  COMMENT '사용자ID',
    email                             VARCHAR(255)                 NOT NULL                  COMMENT '이메일',
    password                          VARCHAR(255)                 NOT NULL                  COMMENT '비밀번호',
    name                              VARCHAR(100)                 NOT NULL                  COMMENT '이름',
    age                               INT                          NOT NULL                  COMMENT '나이',
    gender                            ENUM('MALE', 'FEMALE')       NOT NULL                  COMMENT '성별',
    mobile                            VARCHAR(20)                  NOT NULL                  COMMENT '휴대폰번호',
    signup_date                       DATE                         NOT NULL                  COMMENT '가입일자',
    delete_yn                         varchar(1)                   NOT NULL                  COMMENT '삭제여부',
    created_user_id                   BIGINT           	           NOT NULL                  COMMENT '등록자ID',
    created_datetime                  DATETIME         	           NOT NULL                  COMMENT '등록일시',
    modified_user_id                  BIGINT           	           NOT NULL                  COMMENT '수정자ID',
    modified_datetime                 DATETIME         	           NOT NULL                  COMMENT '수정일시',

    CONSTRAINT pk_user PRIMARY KEY (user_id)
) ENGINE = INNODB DEFAULT CHARSET=utf8mb4 COMMENT='사용자';
