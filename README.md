# API Documentation
### Base URL : /api/v3/app

## Endpoint 1: Get All Events
### End-point: GET /events
- Returns all events.

### Response

Returns all events in json array object. Each event object contains the following fields with status code 200 (OK):
```json
[
  {
    "id": "event_id",
    "type": "event_type",
    "eventName": "event_name",
    "tagLine": "tags",
    "scheduleDate": "yyy-mm-dd",
    "scheduleStartTime": "HH:mm:ss",
    "scheduleEndTime": "HH:mm:ss",
    "description": "event description",
    "imageBase64": "image in base64 format",
    "moderator": "moderator",
    "eventCategory": "eventCategory",
    "eventSubCategory": "subcategory",
    "rigorRank": "rigorRank <integer>",
    "uid": "integer <integer>"
  }
]
```

## Endpoint 2:Get specified event
### Endpoint : GET /events?id={id}
### Request Parameters
- parameter : id
- type : integer
- description : The unique identifier of the event

### Response

- Returns an event object with the following fields with status code 200(OK):

```json
  {
    "id": "event_id",
    "type": "event_type",
    "eventName": "event_name",
    "tagLine": "tags",
    "scheduleDate": "yyy-mm-dd",
    "scheduleStartTime": "HH:mm:ss",
    "scheduleEndTime": "HH:mm:ss",
    "description": "event description",
    "imageBase64": "image in base64 format",
    "moderator": "moderator",
    "eventCategory": "eventCategory",
    "eventSubCategory": "subcategory",
    "rigorRank": "rigorRank <integer>",
    "uid": "integer <integer>"
  }
```

## Endpoint 3: Get Filtered events
### End-point: GET /events?type={type}&limit={limit}&page={page}
- Returns all events with an optional filter by type and pagination
### Request Parameters
- parameter : type(optional),limit,page
- type : String(optional),integer,integer respectively
- description : The type of the event to filter by,The maximum number of events to return per page,The page number to return respectively.

### Response

Returns an array of event objects with a maximum of limit events per page. Each event object contains the following fields with status code 200(OK):
```json
[
  {
    "id": "event_id",
    "type": "event_type",
    "eventName": "event_name",
    "tagLine": "tags",
    "scheduleDate": "yyy-mm-dd",
    "scheduleStartTime": "HH:mm:ss",
    "scheduleEndTime": "HH:mm:ss",
    "description": "event description",
    "imageBase64": "image in base64 format",
    "moderator": "moderator",
    "eventCategory": "eventCategory",
    "eventSubCategory": "subcategory",
    "rigorRank": "rigorRank <integer>",
    "uid": "integer <integer>"
  }
]
```
## Endpoint 4: Creates a new event.
### End-point: POST /events
- Returns created events.
### Request Body
JSON with all the required fields except id (generated automatically) as following.

```json
  {
    "type": "event_type",
    "eventName": "event_name",
    "tagLine": "tags",
    "scheduleDate": "yyy-mm-dd",
    "scheduleStartTime": "HH:mm:ss",
    "scheduleEndTime": "HH:mm:ss",
    "description": "event description",
    "imageBase64": "image in base64 format",
    "moderator": "moderator",
    "eventCategory": "eventCategory",
    "eventSubCategory": "subcategory",
    "rigorRank": "rigorRank <integer>",
    "uid": "integer <integer>"
  }

```

 <h6 style="color:#ff7373">Note:Id is not required for creating event.Id is auto generated.</h6>

### Response

Returns the newly created event data as JSON with a status code of 200 (OK).
```json
  {
    "id": "event_id",
    "type": "event_type",
    "eventName": "event_name",
    "tagLine": "tags",
    "scheduleDate": "yyy-mm-dd",
    "scheduleStartTime": "HH:mm:ss",
    "scheduleEndTime": "HH:mm:ss",
    "description": "event description",
    "imageBase64": "image in base64 format",
    "moderator": "moderator",
    "eventCategory": "eventCategory",
    "eventSubCategory": "subcategory",
    "rigorRank": "rigorRank <integer>",
    "uid": "integer <integer>"
  }
```

## Endpoint 5: Updates event by ID.
### End-point: PUT /events
- Returns updated events.
### Request Body
JSON with all the required fields with id (id required for updating event) as following.

```json
  {
    "id":"id",
    "type": "event_type",
    "eventName": "event_name",
    "tagLine": "tags",
    "scheduleDate": "yyy-mm-dd",
    "scheduleStartTime": "HH:mm:ss",
    "scheduleEndTime": "HH:mm:ss",
    "description": "event description",
    "imageBase64": "image in base64 format",
    "moderator": "moderator",
    "eventCategory": "eventCategory",
    "eventSubCategory": "subcategory",
    "rigorRank": "rigorRank <integer>",
    "uid": "integer <integer>"
  }

```

<h6 style="color:#ff7373">Note:Id is  required for updating the existing event.</h6>

### Response

Returns the updated event data as JSON with a status code of 200 (OK).
```json
  {
    "id": "event_id",
    "type": "event_type",
    "eventName": "event_name",
    "tagLine": "tags",
    "scheduleDate": "yyy-mm-dd",
    "scheduleStartTime": "HH:mm:ss",
    "scheduleEndTime": "HH:mm:ss",
    "description": "event description",
    "imageBase64": "image in base64 format",
    "moderator": "moderator",
    "eventCategory": "eventCategory",
    "eventSubCategory": "subcategory",
    "rigorRank": "rigorRank <integer>",
    "uid": "integer <integer>"
  }
```

## Endpoint 6:Delete specified event
### Endpoint : Delete /events/{id}
### Path Variable
- Path variable : An integer id associated with an event
- type : integer
- description : The unique identifier of the event
- endpoint example: http://localhost:8080/api/v3/app/events/1 here 1 is id of the event

### Response

- Returns an json object with the following fields with status code 200(OK):

```json
  {
    "event_id": "event_id",
    "status": "ok",
    "message": "success"
  }
```




