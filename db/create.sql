
CREATE TABLE memberships (
                membershipId INTEGER NOT NULL,
                membershipName VARCHAR NOT NULL,
                membershipPrice VARCHAR NOT NULL,
                CONSTRAINT memberships_pk PRIMARY KEY (membershipId)
);


CREATE TABLE members (
                memberId INTEGER NOT NULL,
                lastName VARCHAR(20) NOT NULL,
                firstName VARCHAR(20) NOT NULL,
                address VARCHAR NOT NULL,
                phoneNumber VARCHAR NOT NULL,
                dateJoined VARCHAR NOT NULL,
                membershipId INTEGER NOT NULL,
                CONSTRAINT members_pk PRIMARY KEY (memberId)
);


ALTER TABLE members ADD CONSTRAINT memberships_members_fk
FOREIGN KEY (membershipId)
REFERENCES memberships (membershipId)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
