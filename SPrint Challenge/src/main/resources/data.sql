DELETE
FROM coins;

INSERT INTO coins (coinid, name, nameplural, value, quantity)
           VALUES (1, 'Dollar', 'Dollars', 1.00, 5),
                  (2, 'Dollar', 'Dollars', 1.00, 1),
                  (3, 'Quarter', 'Quarters', 0.25, 1),
                  (4, 'Dime', 'Dimes', 0.10, 1),
                  (5, 'Dime', 'Dimes', 0.10, 7),
                  (6, 'Nickel', 'Nickels', 0.05, 3),
                  (7, 'Penny', 'Pennies', 0.01, 10);

alter sequence hibernate_sequence restart with 15;