CREATE TABLE IF NOT EXISTS customer (
    id BIGINT(5) AUTO_INCREMENT PRIMARY KEY COMMENT '식별자',
    name VARCHAR(50) NOT NULL COMMENT '이름',
    email VARCHAR(50) NOT NULL COMMENT 'email',
    mobile_number VARCHAR(50) NOT NULL COMMENT '번호'
);
COMMENT ON TABLE customer is '샘플 테이블';

