package software.ulpgc.kata3;

public record Application(String name, String category, double rating, int reviews, String size, String installs, String type, String price, String contentRating, String genres, String lastUpdate, String currentVer, String androidVer) {
    @Override
    public String toString() {
        return "Application{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", reviews=" + reviews +
                ", size='" + size + '\'' +
                ", installs='" + installs + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", contentRating='" + contentRating + '\'' +
                ", genres='" + genres + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", currentVer='" + currentVer + '\'' +
                ", androidVer='" + androidVer + '\'' +
                '}';
    }
}
