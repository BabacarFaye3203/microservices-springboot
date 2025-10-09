CREATE TABLE fraud (
                          id SERIAL PRIMARY KEY,
                          uuid VARCHAR(255),
                          customer_id VARCHAR(255),
                          isFraud BOOLEAN
);
