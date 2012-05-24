/*
 * Script that helps you to generate an updated font awesome icons enum.
 *
 * - Just go to: http://fortawesome.github.com/Font-Awesome/
 * - Open the browser console
 * - paste this code and execute
 * - thats it
 *
 * @author Carlos A Becker
 */

var i = 'icon-';
var allclasses = [];
$('ul.the-icons li').each(function () {
    var c = $(this).attr('class');
    c = c.substr(c.indexOf(i) + i.length);
    allclasses.push(c);
});

allclasses.sort();

$(allclasses).each(function () {
    var c = this;
    console.log(c.replace("-", "_").toUpperCase() + '("' + c + '"),');
});
