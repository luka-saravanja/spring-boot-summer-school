INSERT INTO patient (first_name, last_name, email, age, enlistment_date, gender, status) VALUES ('Luka', 'Lukic', 'luka@email.com', '25', '2020-03-01', 'MALE', 'ENLISTED');
INSERT INTO patient (first_name, last_name, email, age, enlistment_date, gender, status) VALUES ('Marko', 'Markic', 'marko@email.com', '23', '2020-05-01', 'MALE', 'ENLISTED');
INSERT INTO patient (first_name, last_name, email, age, enlistment_date, gender, status) VALUES ('Petar', 'Peric', 'petar@email.com', '20', '2019-03-01', 'MALE', 'ENLISTED');


INSERT INTO doctor(first_name, last_name, doctor_expertise) VALUES ('Pedijatar', 'Pedijatric', 'PEDIATRICIAN');
INSERT INTO doctor(first_name, last_name, doctor_expertise) VALUES ('Plastik', 'Kirurgic', 'PLASTIC_SURGEON');

INSERT INTO symptom(description) VALUES ('Fever');
INSERT INTO symptom(description) VALUES ('Coughing');
INSERT INTO symptom(description) VALUES ('Headache');

INSERT INTO patient_medical_record(diagnosis, treatment) VALUES ('Diagnosis 1', 'Medic 1');
INSERT INTO patient_medical_record(diagnosis, treatment) VALUES ('Diagnosis 2', 'Medic 2');
INSERT INTO patient_medical_record(diagnosis, treatment) VALUES ('Diagnosis 3', 'Medic 3');

INSERT INTO medical_record_symptoms(patient_medical_record_id, symptom_id) VALUES (1,1);
INSERT INTO medical_record_symptoms(patient_medical_record_id, symptom_id) VALUES (2,2);
INSERT INTO medical_record_symptoms(patient_medical_record_id, symptom_id) VALUES (3,3);

UPDATE patient SET patient_medical_record_id = 1 WHERE patient_id = 1;
UPDATE patient SET patient_medical_record_id = 2 WHERE patient_id = 2;
UPDATE patient SET patient_medical_record_id = 3 WHERE patient_id = 3;

INSERT INTO patient_treatment_history(treatment_remark, new_status, patient_id, doctor_id) VALUES ('Remark 1', 'DIAGNOSED', 1, 1);
INSERT INTO patient_treatment_history(treatment_remark, new_status, patient_id, doctor_id) VALUES ('Remark 2', 'DIAGNOSED', 1, 2);
INSERT INTO patient_treatment_history(treatment_remark, new_status, patient_id, doctor_id) VALUES ('Remark 3', 'DIAGNOSED', 2, 1);
INSERT INTO patient_treatment_history(treatment_remark, new_status, patient_id, doctor_id) VALUES ('Remark 3', 'DIAGNOSED', 2, 2);
INSERT INTO patient_treatment_history(treatment_remark, new_status, patient_id, doctor_id) VALUES ('Remark 3', 'DIAGNOSED', 3, 2);
