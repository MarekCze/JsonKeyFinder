# JsonKeyFinder User Guide

In order for this parser to work correctly you will need 3 things, the GSON library, a list of strings that will tell the parser what you want, and a map that will store the retrieved data as key:value pairs.

## Getting it working

In this example I will be using a JSON response from a web API that has multiple objects inside an array. Each object has the following structure:

![JSON structure](https://github.com/MarekCze/JsonKeyFinder/blob/master/img/json_sample.PNG)

To get a value from your JSON response, follow these steps:

1. Instantiate GSON (line 4)
2. Convert server response by calling the fromJson method and passing in the reader/JSON file and the JsonElement.class argument. This HAS to be saved in a JsonElement variable, the parser won't work otherwise. (line 7)
3. Instantiate JsonKeyFinder (line 9)
4. Create a HashMap to store the key:value pairs you want (line 11)
5. Call the parseElement method to get your values, passing in the JsonElement variable from step 2, along with the strings which tell the parser what keys you want to retrieve and how to get to them. (line 15)

Here is the code for the above steps

![JsonKeyParser setup](https://github.com/MarekCze/JsonKeyFinder/blob/master/img/jkf%20setup.PNG)

The method call at line 15 retrieves whatever is in the "href" key inside an object, inside the "wp:term" array which is inside the "_links" object. All you have to do is pass in the names of each nested object and/or array in which the key you want is stored. Essentially you're giving the parser a path to follow to get to the key. If there is an object or array with no name, the parser will search through it automatically.

If you wanted to get the "rendered" key inside the "title" object instead, the method call would look like this:

![method call](https://github.com/MarekCze/JsonKeyFinder/blob/master/img/single%20key%20value%20pair.PNG)