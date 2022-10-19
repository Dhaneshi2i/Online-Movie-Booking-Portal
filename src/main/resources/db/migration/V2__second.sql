CREATE TABLE tickets (
  id INT AUTO_INCREMENT NOT NULL,
   no_of_seats INT NOT NULL,
   ticket_status BIT(1) NOT NULL,
   booking_id INT NULL,
   CONSTRAINT pk_tickets PRIMARY KEY (id)
);

ALTER TABLE tickets ADD CONSTRAINT FK_TICKETS_ON_BOOKING FOREIGN KEY (booking_id) REFERENCES booking (id);