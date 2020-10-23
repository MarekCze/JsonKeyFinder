# JsonKeyFinder User Guide

In order for this parser to work correctly you will need 2 things, the GSON library, a list of strings that will tell the parser what you want, and a map that will store the retrieved data as key:value pairs.

## Getting it working

In this example I will be using a JSON response from a web API that has multiple objects inside an array. Each object has the following structure:

![JSON structure](https://github.com/MarekCze/JsonKeyFinder/blob/master/img/json_sample.PNG)

To get a value from your JSON response, follow these steps:

1. Instantiate GSON (line 71)
2. Convert server response by calling the fromJson method and passing in the reader/JSON file and the JsonElement.class argument. This HAS to be saved in a JsonElement variable, the parser won't work otherwise. (line 72)
3. Instantiate JsonKeyFinder (line 74)
4. Create a HashMap to store the key:value pairs you want
5. Call the parseElement method to get your values, passing in the JsonElement variable from step 2, along with the strings which tell the parser what keys you want to retrieve and how to get to them.

Here is the code for the above steps

![JsonKeyParser setup](https://github.com/MarekCze/JsonKeyFinder/blob/master/img/jkf%20setup.PNG)