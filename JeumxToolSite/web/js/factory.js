/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


class Factory {
    
    constructor() {
        
    }
    
    /**
     * Returns the page header
     * @returns {String}
     */
    getHeader() {
        
        return "<div class='load'></div>"+
                "<div class='navigation'><span class='titling'>Jeumx Tool</span>"+
                "<center><table border='0'><tr><th>"+
                "<a target='_self' href='index.html'>Home</a>"+
                "<a target='_self' href='download.html'>Download</a>"+
                "<a target='_self' href='doc.html'>Documentation</a>"+
                "<a target='_self' href='donate.html'>Donate</a>"+
                "<a target='_self' href='contact.html'>Contact</a>"+
                "</th></tr></table></center></div>";
    }
    
    /**
     * Returns a simple footer
     * @returns {String}
     */
    getFooter() {
        
        return "<div class='footer'>Jeumx Tool <p/>© Remote Station 2022. All rights reserved.</div>";
    }
    
    /**
     * To set page content
     * @param {type} content
     */
    setContent(content) {
        this.content=content;
    }
    
    generatePage() {
        
        return this.getHeader()+"<center><table border='0'><tr><td class='content'>"
                +this.content+"</td></tr></table></center>"+this.getFooter();
    }
    
}