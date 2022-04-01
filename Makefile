default: run

run: ShowSearcherApp.class
	java ShowSearcherApp

ShowSearcherApp.class: ShowSearcherApp.java ShowSearcherFrontend.class ShowSearcherBackend.class ShowLoader.class
	javac ShowSearcherApp.java

ShowSearcherFrontend.class: ShowSearcherFrontend.java ShowSearcherBackend.class IShowSearcherFrontend.class
	javac ShowSearcherFrontend.java

IShowSearcherFrontend.class: IShowSearcherFrontend.java
	javac IShowSearcherFrontend.java




ShowSearcherBackend.class: ShowSearcherBackend.java HashTableSortedSets.class IShowSearcherBackend.class
	javac ShowSearcherBackend.java

IShowSearcherBackend.class: IShowSearcherBackend.java
	javac IShowSearcherBackend.java

HashTableSortedSets.class: HashTableSortedSets.java HashtableMap.class IHashTableSortedSets.class
	javac HashTableSortedSets.java

IHashTableSortedSets.class: IHashTableSortedSets.java
	javac IHashTableSortedSets.java

HashtableMap.class: HashtableMap.java MapADT.class KeyValuePair.class MapADT.class
	javac HashtableMap.java

MapADT.class: MapADT.java
	javac MapADT.java

KeyValuePair.class: KeyValuePair.java
	javac KeyValuePair.java



ShowLoader.class: ShowLoader.java Show.class IShowLoader.class
	javac ShowLoader.java

IShowLoader.class: IShowLoader.java
	javac IShowLoader.java

Show.class: Show.java IShow.class
	javac Show.java

IShow.class: IShow.java
	javac IShow.java



#Dont think we need any of these but I am keeping them in case
#ShowHolder.class: ShowHolder.java
#	javac ShowHolder.java
#
#Surya_ShowSearcherBackendPlaceholder.class: Surya_ShowSearcherBackendPlaceholder.java
#	javac Surya_ShowSearcherBackendPlaceholder.java




runTests: runFrontendDeveloperTests runBackendDeveloperTests runAlgorithmEngineerTests runDataWranglerTests

runFrontendDeveloperTests: FrontendDeveloperTests.class
	java FrontendDeveloperTests

runBackendDeveloperTests: BackendDeveloperTests.class
	java BackendDeveloperTests

runAlgorithmEngineerTests: AlgorithmEngineerTests.class HashtableMapTests.class
	java AlgorithmEngineerTests
	java HashtableMapTests

runDataWranglerTests: DataWranglerTests.class
	java DataWranglerTests

FrontendDeveloperTests.class: FrontendDeveloperTests.java ShowSearcherFrontend.class ShowSearcherBackendPlaceholder.class TextUITester.class
	javac FrontendDeveloperTests.java

ShowSearcherBackendPlaceholder.class: ShowSearcherBackendPlaceholder.java Show.class
	javac ShowSearcherBackendPlaceholder.java

TextUITester.class: TextUITester.java
	javac TextUITester.java

BackendDeveloperTests.class: BackendDeveloperTests.java HashtableMap.class HashTableSortedSets.class
	javac BackendDeveloperTests.java

AlgorithmEngineerTests.class: AlgorithmEngineerTests.java HashTableSortedSets.java
	javac AlgorithmEngineerTests.java

HashtableMapTests.class: HashtableMapTests.java HashtableMap.class IHashTableSortedSets.class KeyValuePair.class MapADT.class
	javac HashtableMapTests.java

DataWranglerTests.class: DataWranglerTests.java Show.class ShowLoader.class
	javac DataWranglerTests.java

clean:
	rm *.class
