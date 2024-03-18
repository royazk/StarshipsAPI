# Starships API
This app provides an API which displays ordered information on various entities from the Star Wars films by their statistics.

The data comes from SWAPI, a public Star Wars REST API.

The service presents an API that can:

- Surface a list of starships sorted by name
- Allow the sort order to be ascending or descending
- Allow the sort key to be changed (e.g. sort by length or cost rather than name)

To run: Start the application and navigate to http://localhost:8080/api/v1/allStarships/name/asc

This will display a list of all starships by name ascending

If you would like to reverse the order, change asc to **desc**

Currently, the sort key spans the following:

- name
- model
