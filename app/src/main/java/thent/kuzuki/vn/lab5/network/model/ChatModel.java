package thent.kuzuki.vn.lab5.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChatModel {
    private int id;
    private int post;
    private int parent;
    private int author;
    private String author_name;
    private String author_url;
    private String date;
    private String date_gmt;
    private ContentBean content;
    private String link;
    private String status;
    private String type;
    private AuthorAvatarUrlsBean author_avatar_urls;
    private LinksBean _links;
    private List<?> meta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_gmt() {
        return date_gmt;
    }

    public void setDate_gmt(String date_gmt) {
        this.date_gmt = date_gmt;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AuthorAvatarUrlsBean getAuthor_avatar_urls() {
        return author_avatar_urls;
    }

    public void setAuthor_avatar_urls(AuthorAvatarUrlsBean author_avatar_urls) {
        this.author_avatar_urls = author_avatar_urls;
    }

    public LinksBean get_links() {
        return _links;
    }

    public void set_links(LinksBean _links) {
        this._links = _links;
    }

    public List<?> getMeta() {
        return meta;
    }

    public void setMeta(List<?> meta) {
        this.meta = meta;
    }

    public static class ContentBean {
        /**
         * rendered : <p>How are you ?</p>

         */

        private String rendered;

        public String getRendered() {
            return rendered;
        }

        public void setRendered(String rendered) {
            this.rendered = rendered;
        }
    }

    public static class AuthorAvatarUrlsBean {
        /**
         * 24 : http://0.gravatar.com/avatar/320614d3587a32a9dd4207c3b03b44f3?s=24&d=mm&r=g
         * 48 : http://0.gravatar.com/avatar/320614d3587a32a9dd4207c3b03b44f3?s=48&d=mm&r=g
         * 96 : http://0.gravatar.com/avatar/320614d3587a32a9dd4207c3b03b44f3?s=96&d=mm&r=g
         */

        @SerializedName("24")
        private String _$24;
        @SerializedName("48")
        private String _$48;
        @SerializedName("96")
        private String _$96;

        public String get_$24() {
            return _$24;
        }

        public void set_$24(String _$24) {
            this._$24 = _$24;
        }

        public String get_$48() {
            return _$48;
        }

        public void set_$48(String _$48) {
            this._$48 = _$48;
        }

        public String get_$96() {
            return _$96;
        }

        public void set_$96(String _$96) {
            this._$96 = _$96;
        }
    }

    public static class LinksBean {
        private List<SelfBean> self;
        private List<CollectionBean> collection;
        private List<AuthorBean> author;
        private List<UpBean> up;

        public List<SelfBean> getSelf() {
            return self;
        }

        public void setSelf(List<SelfBean> self) {
            this.self = self;
        }

        public List<CollectionBean> getCollection() {
            return collection;
        }

        public void setCollection(List<CollectionBean> collection) {
            this.collection = collection;
        }

        public List<AuthorBean> getAuthor() {
            return author;
        }

        public void setAuthor(List<AuthorBean> author) {
            this.author = author;
        }

        public List<UpBean> getUp() {
            return up;
        }

        public void setUp(List<UpBean> up) {
            this.up = up;
        }

        public static class SelfBean {
            /**
             * href : http://asian.dotplays.com/wp-json/wp/v2/comments/171
             */

            private String href;

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class CollectionBean {
            /**
             * href : http://asian.dotplays.com/wp-json/wp/v2/comments
             */

            private String href;

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class AuthorBean {
            /**
             * embeddable : true
             * href : http://asian.dotplays.com/wp-json/wp/v2/users/1
             */

            private boolean embeddable;
            private String href;

            public boolean isEmbeddable() {
                return embeddable;
            }

            public void setEmbeddable(boolean embeddable) {
                this.embeddable = embeddable;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class UpBean {
            /**
             * embeddable : true
             * post_type : post
             * href : http://asian.dotplays.com/wp-json/wp/v2/posts/377
             */

            private boolean embeddable;
            private String post_type;
            private String href;

            public boolean isEmbeddable() {
                return embeddable;
            }

            public void setEmbeddable(boolean embeddable) {
                this.embeddable = embeddable;
            }

            public String getPost_type() {
                return post_type;
            }

            public void setPost_type(String post_type) {
                this.post_type = post_type;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }
    }
}
