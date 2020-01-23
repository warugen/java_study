DROP TABLE STUDENT;
DROP TABLE MAJOR;

CREATE TABLE MAJOR (
    mNO     NUMBER(1,0)     PRIMARY KEY,
    mNAME   VARCHAR2(50)    UNIQUE );
    
INSERT INTO MAJOR VALUES (1, '��ǻ�Ͱ���');
INSERT INTO MAJOR VALUES (2, '�濵������');
INSERT INTO MAJOR VALUES (3, '���������');
INSERT INTO MAJOR VALUES (4, '����������');
INSERT INTO MAJOR VALUES (5, '���ؿ�ȭ��');

SELECT * FROM MAJOR;

DROP SEQUENCE STD_SEQ;
CREATE SEQUENCE STD_SEQ
  INCREMENT BY 1 
  MAXVALUE 999 
  NOCYCLE
  NOCACHE;
  
CREATE TABLE STUDENT (
    sNO     VARCHAR2(10)    PRIMARY KEY,
    sNAME   VARCHAR2(50) ,
    mNO     NUMBER(1,0)     REFERENCES MAJOR(mNO),
    SCORE   NUMBER(3,0)     DEFAULT 0 CHECK(SCORE>=0 AND SCORE <=100),
    sEXPEL  NUMBER(1,0)     DEFAULT 0 CHECK(sEXPEL = 0 OR sEXPEL =1)
);

-- 1�� ������ �л� �Է�
-- �̸�, ������, ������ �Է¹޾� 
-- �й��� �������� �̿��Ͽ� "����⵵||�а���ȣ||������ȣ"�� �Է��Ѵ�.

SELECT mNO FROM MAJOR WHERE mNAME = '��ǻ�Ͱ���';

SELECT TO_CHAR(SYSDATE,'YYYY') FROM DUAL;

SELECT TRIM(TO_CHAR(STD_SEQ.nextval,'000')) FROM DUAL;

SELECT TO_CHAR(SYSDATE,'YYYY') || (SELECT mNO FROM MAJOR WHERE mNAME = '��ǻ�Ͱ���') || TRIM(TO_CHAR(STD_SEQ.nextval,'000')) FROM DUAL;


INSERT INTO STUDENT VALUES (
    TO_CHAR(SYSDATE,'YYYY') || (SELECT mNO FROM MAJOR WHERE mNAME = '��ǻ�Ͱ���') || TRIM(TO_CHAR(STD_SEQ.nextval,'000')),
    '���켺',
    (SELECT mNO FROM MAJOR WHERE mNAME = '��ǻ�Ͱ���'),
    90,
    0 );

INSERT INTO STUDENT VALUES (
    TO_CHAR(SYSDATE,'YYYY') || (SELECT mNO FROM MAJOR WHERE mNAME = '��ǻ�Ͱ���') || TRIM(TO_CHAR(STD_SEQ.nextval,'000')),
    '�ڼ���',
    (SELECT mNO FROM MAJOR WHERE mNAME = '��ǻ�Ͱ���'),
    80,
    0);

INSERT INTO STUDENT VALUES (
    TO_CHAR(SYSDATE,'YYYY') || (SELECT mNO FROM MAJOR WHERE mNAME = '���������') || TRIM(TO_CHAR(STD_SEQ.nextval,'000')),
    '�����',
    (SELECT mNO FROM MAJOR WHERE mNAME = '���������'),
    20,
    0 );

INSERT INTO STUDENT VALUES (
    TO_CHAR(SYSDATE,'YYYY') || (SELECT mNO FROM MAJOR WHERE mNAME = '��ǻ�Ͱ���') || TRIM(TO_CHAR(STD_SEQ.nextval,'000')),
    'ȫ�浿',
    (SELECT mNO FROM MAJOR WHERE mNAME = '����������'),
    95,
    0 );

INSERT INTO STUDENT VALUES (
    TO_CHAR(SYSDATE,'YYYY') || (SELECT mNO FROM MAJOR WHERE mNAME = '���ؿ�ȭ��') || TRIM(TO_CHAR(STD_SEQ.nextval,'000')),
    '������',
    (SELECT mNO FROM MAJOR WHERE mNAME = '���ؿ�ȭ��'),
    100,
    0 );

SELECT * FROM STUDENT;

--  2�� ������ ���ϴ� �а��̸��� �Է¹޾�
--  �а��� ��ȸ�� ������ �߰��Ͽ� ������ ���� ������ �̸�(��ȣ)�� ���
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE
FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO AND mNAME = '��ǻ�Ͱ���' ORDER BY SCORE DESC);



-- 3�� ������ ���������� ���� ��ü �л��� ��ȸ �� ������ ���� ������ �Ʒ��� ���� ����Ѵ�
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE
FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO AND sEXPEL = 0 ORDER BY SCORE DESC);


COMMIT;

-----------------------------------------------------------------------------------------------------
-- �л�����GUI���� SQL����
-----------------------------------------------------------------------------------------------------

-- �޺��ڽ��� �����߰� (MNAME)
SELECT MNAME FROM MAJOR;

-- �й��˻� (SNO, SNAME, MNAME, SOCRE)
SELECT * 
FROM STUDENT S, MAJOR M
WHERE S.MNO = M.MNO AND SNO = '20205005';

-- �̸��˻� (SNO, SNAME, MNAME, SOCRE)
SELECT * 
FROM STUDENT S, MAJOR M
WHERE S.MNO = M.MNO AND SNAME = 'ȫ�浿';

-- �����˻�(RANK, NAME_NO, MNAME, SOCRE) �������-> 1 ������(20205005) ���ؿ�ȭ��(5) 100
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||MNO||')' MNAME_NO , SCORE
FROM (SELECT SNO, SNAME, MNAME, S.MNO, SCORE FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO AND mNAME = '���ؿ�ȭ��' ORDER BY SCORE DESC);

SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||MNO||')' MNAME_NO , SCORE
FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO AND mNAME = '���ؿ�ȭ��' ORDER BY SCORE DESC);

-- �л��Է� (INSERT)
INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE) VALUES (
    TO_CHAR(SYSDATE,'YYYY') || (SELECT mNO FROM MAJOR WHERE mNAME = '���ؿ�ȭ��') || TRIM(TO_CHAR(STD_SEQ.nextval,'000')),
    '�ѿ���',
    (SELECT mNO FROM MAJOR WHERE mNAME = '���ؿ�ȭ��'),
    85);
    
SELECT * FROM STUDENT;

-- �л����� (UPDATE)
UPDATE STUDENT SET  SNAME = '�ڼ���', 
                    MNO = (SELECT MNO FROM MAJOR WHERE MNAME = '�濵������'), 
                    SCORE = 70
WHERE SNO = '20201002';

-- �л���� (RANK, NAME_NO, MNAME, SCORE) �������-> 1 ������(20205005) ���ؿ�ȭ��(5) 100
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||MNO||')' MNAME_NO , SCORE
FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO AND SEXPEL = 0 ORDER BY SCORE DESC);

-- ��������� (RANK, NAME_NO, MNAME, SCORE) �������-> 1 ������(20205005) ���ؿ�ȭ��(5) 100
SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||MNO||')' MNAME_NO , SCORE
FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO AND SEXPEL = 1 ORDER BY SCORE DESC);

-- ����ó�� (UPDATE)
UPDATE STUDENT SET SEXPEL = 1 WHERE SNO = '201001';
UPDATE STUDENT SET SEXPEL = 0 WHERE SNO = '20201001'; 

COMMIT;














































