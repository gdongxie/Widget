package zzl.com.eventbustest.RecyclerView.Bean;

import java.util.List;

/**
 * Created by ZZL on 2018/4/9.
 * Email:gdongxie@gmail.com
 */

public class MeiNvBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-03-06 14:11","title":"【美D共享】◆ 秋日午后","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-10/24/15/20151024150003941-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6823592-0-1.html"},{"ctime":"2016-03-06 14:11","title":"玉人来","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-10/28/13/201510281356332711-3182465.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6827528-0-1.html"},{"ctime":"2016-03-06 14:11","title":"[贴图]美女小白","description":"华声美女","picUrl":"http://image.hnol.net/bbs/uface/a/2014-11/11/09/2014111109330752354.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6827024-0-1.html"},{"ctime":"2016-03-06 14:11","title":"丰硕","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-10/28/10/20151028102137191-4217076.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6827327-0-1.html"},{"ctime":"2016-03-06 14:11","title":"桃花情歌","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-10/28/12/201510281203258661-3182465.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6827338-0-1.html"},{"ctime":"2016-03-06 14:11","title":"山涧丽人","description":"华声美女","picUrl":"http://image.hnol.net/bbs/uface/a/2014-11/11/09/2014111109330752354.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6827329-0-1.html"},{"ctime":"2016-03-06 14:11","title":"美腿秀271（Aries 2015.10.28）","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-10/28/17/20151028172646951-2285289.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6828202-0-1.html"},{"ctime":"2016-03-06 14:11","title":"【美D共享】◆ 一菲Faye","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-10/24/15/20151024151421351-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6823686-0-1.html"},{"ctime":"2016-03-06 14:11","title":"《蜕变》2\u2015\u2015私人订制系列","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-10/24/15/201510241517404471-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6827364-0-1.html"},{"ctime":"2016-03-06 14:11","title":"清新旗袍一组","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-10/29/13/201510291343497561-4185651.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6829660-0-1.html"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2016-03-06 14:11
         * title : 【美D共享】◆ 秋日午后
         * description : 华声美女
         * picUrl : http://image.hnol.net/c/2015-10/24/15/20151024150003941-2089977.jpg
         * url : http://bbs.voc.com.cn/mm/meinv-6823592-0-1.html
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
