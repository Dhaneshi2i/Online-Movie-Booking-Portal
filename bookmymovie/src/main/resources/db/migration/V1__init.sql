CREATE TABLE roles (
  id INT AUTO_INCREMENT NOT NULL,
   role_type VARCHAR(255) NULL,
   CONSTRAINT pk_roles PRIMARY KEY (id)
);
CREATE TABLE users (
  id INT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NULL,
   email_id VARCHAR(255) NULL,
   contact_number BIGINT NOT NULL,
   password VARCHAR(255) NULL,
   roles_id INT NULL,
   created_date date NULL,
   modified_date date NULL,
   status BIT(1) NOT NULL,
   CONSTRAINT pk_users PRIMARY KEY (id)
);