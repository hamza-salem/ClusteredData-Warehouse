# Currency Orders API

This project provides an API endpoint for creating currency orders. The API validates the input data using annotations and returns appropriate responses based on the validity of the input.

## Endpoint

### POST `/currency-orders`

This endpoint accepts a JSON payload representing a currency order and processes it if the input data is valid.

#### Request Body

The request body should be a JSON object with the following fields:

- **id**: `String` (Required)
  - Must not be blank.
  - Must be unique
  - Example: `"12345"`
  
- **fromCurrencyIso**: `String` (Required)
  - Must not be blank.
  - Must be a valid 3-letter ISO currency code (e.g., `USD`, `EUR`).
  - Example: `"USD"`
  
- **toCurrencyIso**: `String` (Required)
  - Must not be blank.
  - Must be a valid 3-letter ISO currency code (e.g., `USD`, `EUR`).
  - Example: `"EUR"`
  
- **timestamp**: `String` (Required)
  - Must not be blank.
  - Must follow the format `yyyy-MM-dd HH:mm:ss`.
  - Example: `"2024-08-10 15:30:00"`
  
- **amount**: `String` (Required)
  - Must not be blank.
  - Must be Double
  - Example: `"1000.00"`

#### Example Request

```json
{
  "id": "12345",
  "fromCurrencyIso": "USD",
  "toCurrencyIso": "EUR",
  "timestamp": "2024-08-10 15:30:00",
  "amount": "1000.00"
}
