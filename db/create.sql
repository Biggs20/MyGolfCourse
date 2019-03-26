
CREATE TABLE courselength (
                courseId INT NOT NULL,
                redFrontNineLength INT NOT NULL,
                redBackNineLength INT NOT NULL,
                redTotalLength INT NOT NULL,
                goldFrontNineLength INT NOT NULL,
                goldBackNineLength INT NOT NULL,
                goldTotalLength INT NOT NULL,
                whiteFrontNineLength INT NOT NULL,
                whiteBackNineLength INT NOT NULL,
                whiteTotalLength INT NOT NULL,
                blueFrontNineLength INT NOT NULL,
                blueBackNineLength INT NOT NULL,
                blueTotalLength INT NOT NULL,
                blackFrontNineLength INT NOT NULL,
                blackBackNineLength INT NOT NULL,
                blackTotalLength INT NOT NULL,
                PRIMARY KEY (courseId)
);


CREATE TABLE course (
                courseId INT NOT NULL,
                courseName VARCHAR(50) NOT NULL,
                address VARCHAR(40) NOT NULL,
                city VARCHAR(20) NOT NULL,
                stateId CHAR(2) NOT NULL,
                PRIMARY KEY (courseId)
);


CREATE TABLE product (
                productId INT AUTO_INCREMENT NOT NULL,
                productName VARCHAR(30) NOT NULL,
                price DECIMAL(4) NOT NULL,
                brand VARCHAR(30) NOT NULL,
                style VARCHAR(30) NOT NULL,
                picture LONGBLOB,
                PRIMARY KEY (productId)
);


CREATE TABLE amenity (
                amenityId INT NOT NULL,
                picture LONGBLOB,
                membershipIdRequired VARCHAR(5) NOT NULL,
                amenityName VARCHAR(30) NOT NULL,
                openHours VARCHAR(150) NOT NULL,
                PRIMARY KEY (amenityId)
);


CREATE TABLE hole (
                holeNumber INT NOT NULL,
                redTeeLength INT NOT NULL,
                goldTeeLength INT NOT NULL,
                whiteTeeLength INT NOT NULL,
                blueTeeLength INT NOT NULL,
                blackTeeLength INT NOT NULL,
                courseId INT NOT NULL,
                par INT NOT NULL,
                mensHandicap INT NOT NULL,
                womensHandicap VARCHAR NOT NULL,
                description VARCHAR(300) NOT NULL,
                picture LONGBLOB,
                PRIMARY KEY (holeNumber)
);


CREATE TABLE membership (
                membershipId INT AUTO_INCREMENT NOT NULL,
                description VARCHAR(200) NOT NULL,
                membershipName VARCHAR(30) NOT NULL,
                membershipPrice DECIMAL NOT NULL,
                PRIMARY KEY (membershipId)
);


CREATE TABLE membershipamenity (
                membershipAmenityId INT NOT NULL,
                membershipId INT NOT NULL,
                amenityId INT NOT NULL,
                PRIMARY KEY (membershipAmenityId)
);


CREATE TABLE member (
                memberId INT AUTO_INCREMENT NOT NULL,
                lastName VARCHAR(20) NOT NULL,
                firstName VARCHAR(20) NOT NULL,
                address VARCHAR(40) NOT NULL,
                city VARCHAR(25) NOT NULL,
                stateId CHAR(2) NOT NULL,
                phoneNumber CHAR(10) NOT NULL,
                dateJoined DATE NOT NULL,
                membershipId INT NOT NULL,
                picture LONGBLOB,
                handicap INT,
                PRIMARY KEY (memberId)
);


CREATE TABLE orderdetail (
                orderNumber INT DEFAULT 100 NOT NULL,
                productId INT NOT NULL,
                memberId INT NOT NULL,
                unitPrice DECIMAL(8) NOT NULL,
                quantity INT NOT NULL,
                extendedPrice DECIMAL(8,2) NOT NULL,
                PRIMARY KEY (orderNumber)
);


ALTER TABLE course ADD CONSTRAINT courselength_course_fk
FOREIGN KEY (courseId)
REFERENCES courselength (courseId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE hole ADD CONSTRAINT courses_holes_fk
FOREIGN KEY (courseId)
REFERENCES course (courseId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE orderdetail ADD CONSTRAINT products_orderdetail_fk
FOREIGN KEY (productId)
REFERENCES product (productId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE membershipamenity ADD CONSTRAINT amenity_membershipamenity_fk
FOREIGN KEY (amenityId)
REFERENCES amenity (amenityId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE member ADD CONSTRAINT memberships_members_fk
FOREIGN KEY (membershipId)
REFERENCES membership (membershipId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE membershipamenity ADD CONSTRAINT memberships_membershipamenity_fk
FOREIGN KEY (membershipId)
REFERENCES membership (membershipId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE orderdetail ADD CONSTRAINT members_orderdetail_fk
FOREIGN KEY (memberId)
REFERENCES member (memberId)
ON DELETE NO ACTION
ON UPDATE NO ACTION;