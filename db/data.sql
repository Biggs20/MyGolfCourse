INSERT INTO course
            (courseId, courseName, address, city, stateId, frontNineLength, backNineLength, totalLength)
VALUES      (1, 'Centennial Valley Country Club', '1600 Centennial Club Dr,', 'Conway', 'AR')


INSERT INTO hole
            (holeNumber, redTeeLength, goldTeeLength, whiteTeeLength, blueTeeLength, blackTeeLength, courseId, par, mensHandicap, womensHandicap, description)
VALUES      (1, 272, 289, 339, 373, 394, 1, 4, 7, 5, 'Great starting hole that provides an opportunity for success or emotional instability. Players need a well placed drive down the left on this straight away hole. Water right on drive and second make the left look good. Making par is a good start to your round'),
            (2, 110, 137, 160, 179, 200, 1, 3, 3, 7, 'A tough hole for the second of the day. A forced carry over water and a deep left bunker make the club choice as important and the shot itself'),
            (3, 231, 265, 322, 344, 364, 1, 4, 17, 11, 'The first good chance for a birdie starts here on this short par four. Deep bunkers front the elevated green with shallow depth. Hitting a good short iron second is the key here'),
            (4, 105, 119, 154, 181, 203, 1, 3, 9, 17, 'This second par 3 on the front looks easy compared to the first one but, it is not. A large bunker defends the middle and right side of this kidney shaped green'),
            (5, 273, 306, 364, 396, 433, 1, 4, 5, 9, 'A mid length par 4 which demands a good drive off the tee on this straight hole with trees bordering both sides. A front to right side bunker protects the entire right side. Therefore, take plenty of club for your second due to the large and deep green'),
            (6, 303, 326, 362, 400, 425, 1, 4, 1, 1, 'Par or better is a great score on the hardest hole on the front side.  A drive down the left side will set up the second shot to a green that slopes hard from right to left.  Staying left of the hole will make putting a little easier'),
            (7, 346, 394, 471, 510, 540, 1, 5, 11, 13, 'A very reachable par five that doglegs left off the tee to a wide landing area. The second shot is either a precise layup or a long approach to a elevated green with water guarding the front right'),
            (8, 248, 273, 350, 371, 409, 1, 4, 13, 15, 'Things are narrow on this shorter par 4 making the tee shot very demanding. A creek crosses the fairway and meanders the length of the hole protecting the left side. Green slopes sharply from back to front making the putting more difficult'),
            (9, 378, 407, 484, 515, 534, 1, 5, 15, 3, 'Layup or try and go over the water or creek on your tee shot is the decision you face here. Hard to reach on your second if you play conservative from the tee, birdie still in play though'),
            (10, 372, 412, 430, 474, 493, 1, 5, 18, 10, 'May be the hole you have been looking for. This very reachable par 5 has a little room on the drive while the second shot into the green is bordered by a pond just a few feet to the right of the green. Chance to get an eagle or birdie to start the back'),
            (11, 314, 330, 359, 379, 397, 1, 4, 2, 2, 'Good luck here on this forced carry over two bodies of water to a narrow cross fairway protected by three large bunkers to the right of the fairway and water all the way to the green on the left. Play smart here to save your round'),
            (12, 312, 337, 396, 430, 456, 1, 4, 4, 8, 'Time to hit a big drive on the longest par 4 on the course. Straight hole that plays a little downhill making club selection on the second a bit difficult. This diagonal green is protected by a right front bunker'),
            (13, 220, 255, 292, 344, 376, 1, 4, 14, 16, 'A 90º dogleg to the right makes the proper club choice a must of the tee on this shorter par 4. Green is severe from back to front and the right bunker is close to the green. Stay below the hole on your second'),
            (14, 98, 126, 162, 175, 190, 1, 3, 8, 16, 'Nice looking hole with a tranquil pond just shy of the green. Large green surface makes this hole look easy from the tee but, a few gentle slopes make for some interesting putting'),
            (15, 398, 457, 511, 534, 557, 1, 5, 16, 4, 'Very hard to reach in two this one. A pond intersects the fairway making longer players hold back off the tee and making a very long shot over water for a chance at the green in two. Good course management hole with a good birdie chance'),
            (16, 100, 123, 170, 190, 206, 1, 3, 6, 12, 'Tough par here for most players. Medium to long par 3 that plays uphill to a green that slopes hard from back to front. Be careful here, three putts are bountiful here'),
            (17, 226, 264, 356, 379, 400, 1, 4, 10, 18, 'Here is that chance to get one back on the day. Shorter par 4 that requires an accurate drive that must avoid the water on the right side. A short iron into the green gives you a chance at birdie. Green has good slope from back to front'),
            (18, 223, 276, 339, 355, 380, 1, 4, 12, 14, 'The finish to a good test of your golfing skills. Drive down the fairway left or attempt the carry over the water on the right. A great drive sets up the hole for a final birdie chance with a short iron approach to a flat green guarded by a front bunker');


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


INSERT INTO amenity
            (amenityId, amenityName, membershipIdRequired, openHours)
VALUES      (1, 'Golf Course', '1-4', 'Monday: 11:30 a.m - Sunset, Tuesday thru Friday: 7:30 a.m. - Sunset, Saturday & Sunday: 7:00 a.m. - Sunset'),
            (2, 'Fitness Center', '1-5', 'All Week: 4:00 a.m. - 11:00 p.m.'),
            (3, 'Restaurant', '1-5', 'Monday: 11:00 a.m. - 10:00 p.m., Tuesday thru Saturday: 11:00 a.m. - 10:00 p.m., Sunday: 11:00 a.m. - 8:00 p.m.'),
            (4, 'Pool', '1-5', 'Memorial Day thru Labor Day: 10:00 a.m. - 7:00 p.m.');
