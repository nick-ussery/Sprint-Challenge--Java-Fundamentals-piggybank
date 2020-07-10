DELETE
FROM coins;

INSERT INTO coins (coinid, name, nameplural, value, quantity)
           VALUES (3, 'Dollar', 'Dollars', 1.00, 5),
                  (6, 'Dollar', 'Dollars', 1.00, 1),
                  (1, 'Quarter', 'Quarters', 0.25, 1),
                  (2, 'Dime', 'Dimes', 0.10, 1),
                  (5, 'Dime', 'Dimes', 0.10, 7),
                  (4, 'Nickel', 'Nickels', 0.05, 3),
                  (7, 'Penny', 'Pennies', 0.01, 10);

alter sequence hibernate_sequence restart with 15;