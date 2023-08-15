# Observation

Used design pattern `strategy` to calculate tax, since there is a different algorithm for each tax type. To maximize polymorphism, the interface `Tax` defines the method that every tax type must implement.
