# Photo Management System

## Features

- Upload photos
- Search for photos using:
  - Tags
  - Name
  - Location
  - Date

## First Solution: Using Maps

To achieve efficient search functionality, I used four separate maps to avoid collisions:

- A map for **tags**
- A map for **names**
- A map for **locations**
- A map for **dates**

Each map follows this pattern:

- The **key** is the attribute (e.g., tag, name, etc.)
- The **value** is a `HashSet` of photos, which helps to avoid duplicates

### Performance

This solution provides **high performance in terms of time complexity**. However, 
it introduces **memory overhead** due to the duplication of photo references across multiple maps.
The same photo may be stored in multiple `HashSet`s (one in each map), increasing memory usage.
