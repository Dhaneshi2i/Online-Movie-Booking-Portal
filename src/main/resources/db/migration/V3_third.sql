UPDATE
  theatre
SET
  status = '1'
WHERE
  status IS NULL;
ALTER TABLE theatre MODIFY status TINYINT(1) NOT NULL;