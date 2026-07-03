abstract static class DataParser {
    final void parse() {
        readData();
        processData();
        saveResults();
    }

    abstract void readData();

    abstract void processData();

    void saveResults() {  // hook — optional override
        System.out.println("Saving to default store");
    }
}

static class CsvParser extends DataParser {
    void readData() {
        System.out.println("Reading CSV");
    }

    void processData() {
        System.out.println("Parsing CSV rows");
    }
}

static class JsonParser extends DataParser {
    void readData() {
        System.out.println("Reading JSON");
    }

    void processData() {
        System.out.println("Parsing JSON nodes");
    }
}

void main() {
    new CsvParser().parse();
}
