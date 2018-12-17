package com.bloodcrown.repositroy.book;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bloodcrown.repositroy.BR;

import java.util.List;

/**
 * 作者 ： BloodCrown
 * 时间 ： 2018/4/26 下午1:56
 * 描述 ：
 */

public class BookResponse {

    private int count;
    private int start;
    private int total;
    private List<Book> books;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public static class Book extends BaseObservable {

        private RatingBean rating;
        private String subtitle;
        private String pubdate;
        private String origin_title;
        private String image;
        private String binding;
        private String catalog;
        private String ebook_url;
        private String pages;
        private ImagesBean images;
        private String alt;
        private String id;
        private String publisher;
        private String isbn10;
        private String isbn13;
        private String title;
        private String url;
        private String alt_title;
        private String author_intro;
        private String summary;
        private String ebook_price;
        private SeriesBean series;
        private String price;
        private List<String> author;
        private List<TagsBean> tags;
        private List<String> translator;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Book)) return false;

            Book book = (Book) o;

            if (rating != null ? !rating.equals(book.rating) : book.rating != null) return false;
            if (subtitle != null ? !subtitle.equals(book.subtitle) : book.subtitle != null) return false;
            if (pubdate != null ? !pubdate.equals(book.pubdate) : book.pubdate != null) return false;
            if (origin_title != null ? !origin_title.equals(book.origin_title) : book.origin_title != null)
                return false;
            if (image != null ? !image.equals(book.image) : book.image != null) return false;
            if (binding != null ? !binding.equals(book.binding) : book.binding != null) return false;
            if (catalog != null ? !catalog.equals(book.catalog) : book.catalog != null) return false;
            if (ebook_url != null ? !ebook_url.equals(book.ebook_url) : book.ebook_url != null) return false;
            if (pages != null ? !pages.equals(book.pages) : book.pages != null) return false;
            if (images != null ? !images.equals(book.images) : book.images != null) return false;
            if (alt != null ? !alt.equals(book.alt) : book.alt != null) return false;
            if (id != null ? !id.equals(book.id) : book.id != null) return false;
            if (publisher != null ? !publisher.equals(book.publisher) : book.publisher != null) return false;
            if (isbn10 != null ? !isbn10.equals(book.isbn10) : book.isbn10 != null) return false;
            if (isbn13 != null ? !isbn13.equals(book.isbn13) : book.isbn13 != null) return false;
            if (title != null ? !title.equals(book.title) : book.title != null) return false;
            if (url != null ? !url.equals(book.url) : book.url != null) return false;
            if (alt_title != null ? !alt_title.equals(book.alt_title) : book.alt_title != null) return false;
            if (author_intro != null ? !author_intro.equals(book.author_intro) : book.author_intro != null)
                return false;
            if (summary != null ? !summary.equals(book.summary) : book.summary != null) return false;
            if (ebook_price != null ? !ebook_price.equals(book.ebook_price) : book.ebook_price != null) return false;
            if (series != null ? !series.equals(book.series) : book.series != null) return false;
            if (price != null ? !price.equals(book.price) : book.price != null) return false;
            if (author != null ? !author.equals(book.author) : book.author != null) return false;
            if (tags != null ? !tags.equals(book.tags) : book.tags != null) return false;
            return translator != null ? translator.equals(book.translator) : book.translator == null;
        }

        @Override
        public int hashCode() {
            int result = rating != null ? rating.hashCode() : 0;
            result = 31 * result + (subtitle != null ? subtitle.hashCode() : 0);
            result = 31 * result + (pubdate != null ? pubdate.hashCode() : 0);
            result = 31 * result + (origin_title != null ? origin_title.hashCode() : 0);
            result = 31 * result + (image != null ? image.hashCode() : 0);
            result = 31 * result + (binding != null ? binding.hashCode() : 0);
            result = 31 * result + (catalog != null ? catalog.hashCode() : 0);
            result = 31 * result + (ebook_url != null ? ebook_url.hashCode() : 0);
            result = 31 * result + (pages != null ? pages.hashCode() : 0);
            result = 31 * result + (images != null ? images.hashCode() : 0);
            result = 31 * result + (alt != null ? alt.hashCode() : 0);
            result = 31 * result + (id != null ? id.hashCode() : 0);
            result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
            result = 31 * result + (isbn10 != null ? isbn10.hashCode() : 0);
            result = 31 * result + (isbn13 != null ? isbn13.hashCode() : 0);
            result = 31 * result + (title != null ? title.hashCode() : 0);
            result = 31 * result + (url != null ? url.hashCode() : 0);
            result = 31 * result + (alt_title != null ? alt_title.hashCode() : 0);
            result = 31 * result + (author_intro != null ? author_intro.hashCode() : 0);
            result = 31 * result + (summary != null ? summary.hashCode() : 0);
            result = 31 * result + (ebook_price != null ? ebook_price.hashCode() : 0);
            result = 31 * result + (series != null ? series.hashCode() : 0);
            result = 31 * result + (price != null ? price.hashCode() : 0);
            result = 31 * result + (author != null ? author.hashCode() : 0);
            result = 31 * result + (tags != null ? tags.hashCode() : 0);
            result = 31 * result + (translator != null ? translator.hashCode() : 0);
            return result;
        }

        @Bindable
        public RatingBean getRating() {
            return rating;
        }


        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        @Bindable
        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        @Bindable
        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        @Bindable
        public String getOrigin_title() {
            return origin_title;
        }

        public void setOrigin_title(String origin_title) {
            this.origin_title = origin_title;
        }

        @Bindable
        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        @Bindable
        public String getBinding() {
            return binding;
        }

        public void setBinding(String binding) {
            this.binding = binding;
        }

        @Bindable
        public String getCatalog() {
            return catalog;
        }

        public void setCatalog(String catalog) {
            this.catalog = catalog;
        }

        @Bindable
        public String getEbook_url() {
            return ebook_url;
        }

        public void setEbook_url(String ebook_url) {
            this.ebook_url = ebook_url;
        }

        @Bindable
        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        @Bindable
        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        @Bindable
        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        @Bindable
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Bindable
        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        @Bindable
        public String getIsbn10() {
            return isbn10;
        }

        public void setIsbn10(String isbn10) {
            this.isbn10 = isbn10;
        }

        @Bindable
        public String getIsbn13() {
            return isbn13;
        }

        public void setIsbn13(String isbn13) {
            this.isbn13 = isbn13;
        }

        @Bindable
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
            notifyPropertyChanged(BR.title);
        }

        @Bindable
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Bindable
        public String getAlt_title() {
            return alt_title;
        }

        public void setAlt_title(String alt_title) {
            this.alt_title = alt_title;
        }

        @Bindable
        public String getAuthor_intro() {
            return author_intro;
        }

        public void setAuthor_intro(String author_intro) {
            this.author_intro = author_intro;
        }

        @Bindable
        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        @Bindable
        public String getEbook_price() {
            return ebook_price;
        }

        public void setEbook_price(String ebook_price) {
            this.ebook_price = ebook_price;
        }

        @Bindable
        public SeriesBean getSeries() {
            return series;
        }

        public void setSeries(SeriesBean series) {
            this.series = series;
        }

        @Bindable
        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
            notifyPropertyChanged(BR.price);
        }

        @Bindable
        public List<String> getAuthor() {
            return author;
        }

        public void setAuthor(List<String> author) {
            this.author = author;
        }

        @Bindable
        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        @Bindable
        public List<String> getTranslator() {
            return translator;
        }

        public void setTranslator(List<String> translator) {
            this.translator = translator;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "rating=" + rating +
                    ", subtitle='" + subtitle + '\'' +
                    ", pubdate='" + pubdate + '\'' +
                    ", origin_title='" + origin_title + '\'' +
                    ", image='" + image + '\'' +
                    ", binding='" + binding + '\'' +
                    ", catalog='" + catalog + '\'' +
                    ", ebook_url='" + ebook_url + '\'' +
                    ", pages='" + pages + '\'' +
                    ", images=" + images +
                    ", alt='" + alt + '\'' +
                    ", id='" + id + '\'' +
                    ", publisher='" + publisher + '\'' +
                    ", isbn10='" + isbn10 + '\'' +
                    ", isbn13='" + isbn13 + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    ", alt_title='" + alt_title + '\'' +
                    ", author_intro='" + author_intro + '\'' +
                    ", summary='" + summary + '\'' +
                    ", ebook_price='" + ebook_price + '\'' +
                    ", series=" + series +
                    ", price='" + price + '\'' +
                    ", author=" + author +
                    ", tags=" + tags +
                    ", translator=" + translator +
                    '}';
        }


        public static class RatingBean {
            /**
             * max : 10
             * numRaters : 17307
             * average : 7.6
             * min : 0
             */

            private int max;
            private int numRaters;
            private String average;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getNumRaters() {
                return numRaters;
            }

            public void setNumRaters(int numRaters) {
                this.numRaters = numRaters;
            }

            public String getAverage() {
                return average;
            }

            public void setAverage(String average) {
                this.average = average;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }

            @Override
            public String toString() {
                return "RatingBean{" +
                        "max=" + max +
                        ", numRaters=" + numRaters +
                        ", average='" + average + '\'' +
                        ", min=" + min +
                        '}';
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img3.doubanio.com/view/subject/s/public/s28850934.jpg
             * large : https://img3.doubanio.com/view/subject/l/public/s28850934.jpg
             * medium : https://img3.doubanio.com/view/subject/m/public/s28850934.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            @Override
            public String toString() {
                return "ImagesBean{" +
                        "small='" + small + '\'' +
                        ", large='" + large + '\'' +
                        ", medium='" + medium + '\'' +
                        '}';
            }
        }

        public static class SeriesBean {
            /**
             * id : 16643
             * title : 李继宏世界名著新译
             */

            private String id;
            private String title;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            @Override
            public String toString() {
                return "SeriesBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        '}';
            }
        }

        public static class TagsBean {
            /**
             * count : 3553
             * name : 小王子
             * title : 小王子
             */

            private int count;
            private String name;
            private String title;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            @Override
            public String toString() {
                return "TagsBean{" +
                        "count=" + count +
                        ", name='" + name + '\'' +
                        ", title='" + title + '\'' +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "BookResponse{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", books=" + books +
                '}';
    }
}
