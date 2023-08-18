# Observation

Used design pattern `chain of responsibility` to calculate discounts, since there is a different algorithm for each discout type, but, we do not know before hand which discount strategy will be used. To maximize polymorphism, the interface `Discount` defines the method that every discount type must implement.
