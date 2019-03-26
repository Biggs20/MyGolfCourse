INSERT INTO course
            (courseId, courseName, address, city, stateId, frontNineLength, backNineLength, totalLength)
VALUES      (1, 'Centennial Valley Country Club', '1600 Centennial Club Dr,', 'Conway', 'AR')


INSERT INTO hole
            (holeNumber, redTeeLength, goldTeeLength, whiteTeeLength, blueTeeLength, blackTeeLength, courseId, par, mensHandicap, womensHandicap)
VALUES      (1, 272, 289, 339, 373, 394, 1, 4, 7, 5),
            (2, 110, 137, 160, 179, 200, 1, 3, 3, 7),
            (3, 231, 265, 322, 344, 364, 1, 4, 17, 11),
            (4, 105, 119, 154, 181, 203, 1, 3, 9, 17),
            (5, 273, 306, 364, 396, 433, 1, 4, 5, 9),
            (6, 303, 326, 362, 400, 425, 1, 4, 1, 1),
            (7, 346, 394, 471, 510, 540, 1, 5, 11, 13),
            (8, 248, 273, 350, 371, 409, 1, 4, 13, 15),
            (9, 378, 407, 484, 515, 534, 1, 5, 15, 3),
            (10, 372, 412, 430, 474, 493, 1, 5, 18, 10),
            (11, 314, 330, 359, 379, 397, 1, 4, 2, 2),
            (12, 312, 337, 396, 430, 456, 1, 4, 4, 8),
            (13, 220, 255, 292, 344, 376, 1, 4, 14, 16),
            (14, 98, 126, 162, 175, 190, 1, 3, 8, 16),
            (15, 398, 457, 511, 534, 557, 1, 5, 16, 4),
            (16, 100, 123, 170, 190, 206, 1, 3, 6, 12),
            (17, 226, 264, 356, 379, 400, 1, 4, 10, 18),
            (18, 223, 276, 339, 355, 380, 1, 4, 12, 14);


INSERT INTO courselength
            (courseId, redFrontNineLength, redBackNineLength, redTotalLength, goldFrontNineLength, goldBackNineLength, goldTotalLength,
            whiteFrontNineLength, whiteBackNineLength, whiteTotalLength, blueFrontNineLength, blueBackNineLength, blueTotalLength,
            blackFrontNineLength, blackBackNineLength, blackTotalLength)
VALUES      (1, 2266, 2263, 4529, 2516, 2580, 5096, 3006, 3015, 6021, 3269, 3260, 6529, 3502, 3455, 6957);


INSERT INTO product
            (productId, productName, price, brand, category)
VALUES      (1, 'Titleist ProV1', 49.99, 'Titleist', 'Golf Balls'),
            (2, 'Titleist ProV1x', 49.99, 'Titleist', 'Golf Balls'),
            (3, 'Taylormade TP5', 44.99, 'Taylormade', 'Golf Balls'),
            (4, 'Taylormade TP5x', 44.99, 'Taylormade', 'Golf Balls'),
            (5, 'Bridgestone Tour B RX', 37.99, 'Bridgestone', 'Golf Balls'),
            (6, 'Bridgestone Tour B X', 37.99, 'Bridgestone','Golf Balls')


INSERT INTO membership
            (membershipId, membershipName, membershipPrice, description)
VALUES      (1, 'Full Membership', 245.00, 'Full privileges for applicant, spouse, and all unmarried, dependent children under age 21, living at home'),
            (2, 'Corporate Membership', 245.00, 'Full privileges for individual officers or staff of a Company or Corporation. Memberships are assigned to an individual, belong to the Company, and are transferable. The family of a member will be covered under the membership'),
            (3, 'Junior Membership', 165.00, 'Ages thirty four and under'),
            (4, 'Senior Membership', 245.00, 'Fifty-five and over'),
            (5, 'Social Membership', 2.91, 'Social membership offers dining privileges to applicant, spouse, & all unmarried, dependent children under the age of 21 living at home')


INSERT INTO member
            (memberId, lastName, firstName, address, city, stateId, phoneNumber, dateJoined, membershipId, handicap)
VALUES      (1, 'Biggerstaff','Bryce', '3040 Pebble Beach Rd', 'Conway', 'AR', '5019444652', '2015-04-04', 3, 7),
            (2, 'Dauksch','Cody', '2130 Destin Dr', 'Conway', 'AR', '8708780000', '2018-03-03', 3, 6),
            (3, 'Madden','Reed', '4569 Lefty Ln', 'Little Rock', 'AR', '5019444652', '2019-03-25', 3, 22),
            (4, 'Dail', 'Matthew', '111 Apple Blossom rd', 'Conway', 'AR', '5013334444', '2015-04-04', 3, 4),
            (5, 'Kordsmeier', 'John', '2130 Destin Dr', 'Conway', 'AR', '5010987654', '2015-03-30', 3, 4),
            (6, 'Moix', 'Austen', '2130 Destin Dr', 'Conway', 'AR', '5015454543', '2016-07-11', 3, 0),
            (7, 'Moon', 'Marshall', '3454 Draw Dr', 'Conway', 'AR', '5014750970', '2018-09-30', 3, 7),
            (8, 'Lefler', 'Matt', '1111 Hybrid Ln', 'Conway', 'AR', '5017776666', '2018-01-01', 3, 10),
            (9, 'Blackwell', 'JT', '2222 Long Swing Ln', 'Conway', 'AR', '5014567123', '2017-06-11', 3, 10),
            (10, 'Alex', 'Smith', '546 Creek Dr', 'Conway', 'AR', '5010980099', '2018-03-30', 3, 10);
