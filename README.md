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

## Second Solution: Using a Single HashSet

To minimize memory overhead, I used a single `HashSet` to store all photos.  
Each photo is stored only once, and searches are performed by iterating through the collection and applying filters.

### Performance

- **Memory usage:** Significantly improved since there is no duplication of photo references.
- **Time complexity:** Slower compared to the 
