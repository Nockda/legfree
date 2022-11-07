/* axios v0.10.0 | (c) 2016 by Matt Zabriskie */ ! function(e, t) {
	"object" == typeof exports && "object" == typeof module ? module.exports = t() : "function" == typeof define && define
		.amd ? define([], t) : "object" == typeof exports ? exports.axios = t() : e.axios = t()
}(this, function() {
	return function(e) {
		function t(n) {
			if (r[n]) return r[n].exports;
			var o = r[n] = {
				exports: {},
				id: n,
				loaded: !1
			};
			return e[n].call(o.exports, o, o.exports, t), o.loaded = !0, o.exports
		}
		var r = {};
		return t.m = e, t.c = r, t.p = "", t(0)
	}([function(e, t, r) {
		e.exports = r(1)
	}, function(e, t, r) {
		"use strict";

		function n(e) {
			this.defaults = i.merge({}, e), this.interceptors = {
				request: new u,
				response: new u
			}
		}
		var o = r(2),
			i = r(3),
			s = r(4),
			u = r(12),
			a = r(13),
			c = r(14),
			f = r(15),
			p = r(8);
		n.prototype.request = function(e) {
			"string" == typeof e && (e = i.merge({
					url: arguments[0]
				}, arguments[1])), e = i.merge(o, this.defaults, {
					method: "get"
				}, e), e.baseURL && !a(e.url) && (e.url = c(e.baseURL, e.url)), e.withCredentials = e.withCredentials || this.defaults
				.withCredentials, e.data = p(e.data, e.headers, e.transformRequest), e.headers = i.merge(e.headers.common || {},
					e.headers[e.method] || {}, e.headers || {}), i.forEach(["delete", "get", "head", "post", "put", "patch",
					"common"
				], function(t) {
					delete e.headers[t]
				});
			var t = [s, void 0],
				r = Promise.resolve(e);
			for (this.interceptors.request.forEach(function(e) {
					t.unshift(e.fulfilled, e.rejected)
				}), this.interceptors.response.forEach(function(e) {
					t.push(e.fulfilled, e.rejected)
				}); t.length;) r = r.then(t.shift(), t.shift());
			return r
		};
		var d = new n(o),
			l = e.exports = f(n.prototype.request, d);
		l.defaults = d.defaults, l.interceptors = d.interceptors, l.create = function(e) {
			return new n(e)
		}, l.all = function(e) {
			return Promise.all(e)
		}, l.spread = r(16), i.forEach(["delete", "get", "head"], function(e) {
			n.prototype[e] = function(t, r) {
				return this.request(i.merge(r || {}, {
					method: e,
					url: t
				}))
			}, l[e] = f(n.prototype[e], d)
		}), i.forEach(["post", "put", "patch"], function(e) {
			n.prototype[e] = function(t, r, n) {
				return this.request(i.merge(n || {}, {
					method: e,
					url: t,
					data: r
				}))
			}, l[e] = f(n.prototype[e], d)
		})
	}, function(e, t, r) {
		"use strict";
		var n = r(3),
			o = /^\)\]\}',?\n/,
			i = {
				"Content-Type": "application/x-www-form-urlencoded"
			};
		e.exports = {
			transformRequest: [function(e, t) {
				return n.isFormData(e) ? e : n.isArrayBuffer(e) ? e : n.isArrayBufferView(e) ? e.buffer : !n.isObject(e) ||
					n.isFile(e) || n.isBlob(e) ? e : (n.isUndefined(t) || (n.forEach(t, function(e, r) {
						"content-type" === r.toLowerCase() && (t["Content-Type"] = e)
					}), n.isUndefined(t["Content-Type"]) && (t["Content-Type"] = "application/json;charset=utf-8")), JSON.stringify(
						e))
			}],
			transformResponse: [function(e) {
				if ("string" == typeof e) {
					e = e.replace(o, "");
					try {
						e = JSON.parse(e)
					} catch (t) {}
				}
				return e
			}],
			headers: {
				common: {
					Accept: "application/json, text/plain, */*"
				},
				patch: n.merge(i),
				post: n.merge(i),
				put: n.merge(i)
			},
			timeout: 0,
			xsrfCookieName: "XSRF-TOKEN",
			xsrfHeaderName: "X-XSRF-TOKEN",
			maxContentLength: -1
		}
	}, function(e, t) {
		"use strict";

		function r(e) {
			return "[object Array]" === w.call(e)
		}

		function n(e) {
			return "[object ArrayBuffer]" === w.call(e)
		}

		function o(e) {
			return "[object FormData]" === w.call(e)
		}

		function i(e) {
			var t;
			return t = "undefined" != typeof ArrayBuffer && ArrayBuffer.isView ? ArrayBuffer.isView(e) : e && e.buffer && e.buffer instanceof ArrayBuffer
		}

		function s(e) {
			return "string" == typeof e
		}

		function u(e) {
			return "number" == typeof e
		}

		function a(e) {
			return "undefined" == typeof e
		}

		function c(e) {
			return null !== e && "object" == typeof e
		}

		function f(e) {
			return "[object Date]" === w.call(e)
		}

		function p(e) {
			return "[object File]" === w.call(e)
		}

		function d(e) {
			return "[object Blob]" === w.call(e)
		}

		function l(e) {
			return e.replace(/^\s*/, "").replace(/\s*$/, "")
		}

		function h() {
			return "undefined" != typeof window && "undefined" != typeof document && "function" == typeof document.createElement
		}

		function m(e, t) {
			if (null !== e && "undefined" != typeof e)
				if ("object" == typeof e || r(e) || (e = [e]), r(e))
					for (var n = 0, o = e.length; o > n; n++) t.call(null, e[n], n, e);
				else
					for (var i in e) e.hasOwnProperty(i) && t.call(null, e[i], i, e)
		}

		function y() {
			function e(e, r) {
				"object" == typeof t[r] && "object" == typeof e ? t[r] = y(t[r], e) : t[r] = e
			}
			for (var t = {}, r = 0, n = arguments.length; n > r; r++) m(arguments[r], e);
			return t
		}
		var w = Object.prototype.toString;
		e.exports = {
			isArray: r,
			isArrayBuffer: n,
			isFormData: o,
			isArrayBufferView: i,
			isString: s,
			isNumber: u,
			isObject: c,
			isUndefined: a,
			isDate: f,
			isFile: p,
			isBlob: d,
			isStandardBrowserEnv: h,
			forEach: m,
			merge: y,
			trim: l
		}
	}, function(e, t, r) {
		"use strict";
		e.exports = function(e) {
			return new Promise(function(t, n) {
				try {
					var o;
					"function" == typeof e.adapter ? o = e.adapter : "undefined" != typeof XMLHttpRequest ? o = r(5) :
						"undefined" != typeof process && (o = r(5)), "function" == typeof o && o(t, n, e)
				} catch (i) {
					n(i)
				}
			})
		}
	}, function(e, t, r) {
		"use strict";
		var n = r(3),
			o = r(6),
			i = r(7),
			s = r(8),
			u = r(9),
			a = "undefined" != typeof window && window.btoa || r(10);
		e.exports = function(e, t, c) {
			var f = c.data,
				p = c.headers;
			n.isFormData(f) && delete p["Content-Type"];
			var d = new XMLHttpRequest,
				l = "onreadystatechange",
				h = !1;
			if ("undefined" == typeof window || !window.XDomainRequest || "withCredentials" in d || u(c.url) || (d = new window
					.XDomainRequest, l = "onload", h = !0), c.auth) {
				var m = c.auth.username || "",
					y = c.auth.password || "";
				p.Authorization = "Basic " + a(m + ":" + y)
			}
			if (d.open(c.method.toUpperCase(), o(c.url, c.params, c.paramsSerializer), !0), d.timeout = c.timeout, d.onprogress =
				function() {}, d.ontimeout = function() {}, d[l] = function() {
					if (d && (4 === d.readyState || h) && 0 !== d.status) {
						var r = "getAllResponseHeaders" in d ? i(d.getAllResponseHeaders()) : null,
							n = c.responseType && "text" !== c.responseType ? d.response : d.responseText,
							o = {
								data: s(n, r, c.transformResponse),
								status: 1223 === d.status ? 204 : d.status,
								statusText: 1223 === d.status ? "No Content" : d.statusText,
								headers: r,
								config: c,
								request: d
							};
						(o.status >= 200 && o.status < 300 || !("status" in d) && d.responseText ? e : t)(o), d = null
					}
				}, d.onerror = function() {
					t(new Error("Network Error")), d = null
				}, d.ontimeout = function() {
					var e = new Error("timeout of " + c.timeout + "ms exceeded");
					e.timeout = c.timeout, e.code = "ECONNABORTED", t(e), d = null
				}, n.isStandardBrowserEnv()) {
				var w = r(11),
					g = c.withCredentials || u(c.url) ? w.read(c.xsrfCookieName) : void 0;
				g && (p[c.xsrfHeaderName] = g)
			}
			if ("setRequestHeader" in d && n.forEach(p, function(e, t) {
					"undefined" == typeof f && "content-type" === t.toLowerCase() ? delete p[t] : d.setRequestHeader(t, e)
				}), c.withCredentials && (d.withCredentials = !0), c.responseType) try {
				d.responseType = c.responseType
			} catch (v) {
				if ("json" !== d.responseType) throw v
			}
			c.progress && ("post" === c.method || "put" === c.method ? d.upload.addEventListener("progress", c.progress) :
					"get" === c.method && d.addEventListener("progress", c.progress)), n.isArrayBuffer(f) && (f = new DataView(f)),
				void 0 === f && (f = null), d.send(f)
		}
	}, function(e, t, r) {
		"use strict";

		function n(e) {
			return encodeURIComponent(e).replace(/%40/gi, "@").replace(/%3A/gi, ":").replace(/%24/g, "$").replace(/%2C/gi,
				",").replace(/%20/g, "+").replace(/%5B/gi, "[").replace(/%5D/gi, "]")
		}
		var o = r(3);
		e.exports = function(e, t, r) {
			if (!t) return e;
			var i;
			if (r) i = r(t);
			else {
				var s = [];
				o.forEach(t, function(e, t) {
					null !== e && "undefined" != typeof e && (o.isArray(e) && (t += "[]"), o.isArray(e) || (e = [e]), o.forEach(
						e,
						function(e) {
							o.isDate(e) ? e = e.toISOString() : o.isObject(e) && (e = JSON.stringify(e)), s.push(n(t) + "=" + n(e))
						}))
				}), i = s.join("&")
			}
			return i && (e += (-1 === e.indexOf("?") ? "?" : "&") + i), e
		}
	}, function(e, t, r) {
		"use strict";
		var n = r(3);
		e.exports = function(e) {
			var t, r, o, i = {};
			return e ? (n.forEach(e.split("\n"), function(e) {
				o = e.indexOf(":"), t = n.trim(e.substr(0, o)).toLowerCase(), r = n.trim(e.substr(o + 1)), t && (i[t] = i[t] ?
					i[t] + ", " + r : r)
			}), i) : i
		}
	}, function(e, t, r) {
		"use strict";
		var n = r(3);
		e.exports = function(e, t, r) {
			return n.forEach(r, function(r) {
				e = r(e, t)
			}), e
		}
	}, function(e, t, r) {
		"use strict";
		var n = r(3);
		e.exports = n.isStandardBrowserEnv() ? function() {
			function e(e) {
				var t = e;
				return r && (o.setAttribute("href", t), t = o.href), o.setAttribute("href", t), {
					href: o.href,
					protocol: o.protocol ? o.protocol.replace(/:$/, "") : "",
					host: o.host,
					search: o.search ? o.search.replace(/^\?/, "") : "",
					hash: o.hash ? o.hash.replace(/^#/, "") : "",
					hostname: o.hostname,
					port: o.port,
					pathname: "/" === o.pathname.charAt(0) ? o.pathname : "/" + o.pathname
				}
			}
			var t, r = /(msie|trident)/i.test(navigator.userAgent),
				o = document.createElement("a");
			return t = e(window.location.href),
				function(r) {
					var o = n.isString(r) ? e(r) : r;
					return o.protocol === t.protocol && o.host === t.host
				}
		}() : function() {
			return function() {
				return !0
			}
		}()
	}, function(e, t) {
		"use strict";

		function r() {
			this.message = "String contains an invalid character"
		}

		function n(e) {
			for (var t, n, i = String(e), s = "", u = 0, a = o; i.charAt(0 | u) || (a = "=", u % 1); s += a.charAt(63 & t >>
					8 - u % 1 * 8)) {
				if (n = i.charCodeAt(u += .75), n > 255) throw new r;
				t = t << 8 | n
			}
			return s
		}
		var o = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
		r.prototype = new Error, r.prototype.code = 5, r.prototype.name = "InvalidCharacterError", e.exports = n
	}, function(e, t, r) {
		"use strict";
		var n = r(3);
		e.exports = n.isStandardBrowserEnv() ? function() {
			return {
				write: function(e, t, r, o, i, s) {
					var u = [];
					u.push(e + "=" + encodeURIComponent(t)), n.isNumber(r) && u.push("expires=" + new Date(r).toGMTString()), n.isString(
							o) && u.push("path=" + o), n.isString(i) && u.push("domain=" + i), s === !0 && u.push("secure"), document.cookie =
						u.join("; ")
				},
				read: function(e) {
					var t = document.cookie.match(new RegExp("(^|;\\s*)(" + e + ")=([^;]*)"));
					return t ? decodeURIComponent(t[3]) : null
				},
				remove: function(e) {
					this.write(e, "", Date.now() - 864e5)
				}
			}
		}() : function() {
			return {
				write: function() {},
				read: function() {
					return null
				},
				remove: function() {}
			}
		}()
	}, function(e, t, r) {
		"use strict";

		function n() {
			this.handlers = []
		}
		var o = r(3);
		n.prototype.use = function(e, t) {
			return this.handlers.push({
				fulfilled: e,
				rejected: t
			}), this.handlers.length - 1
		}, n.prototype.eject = function(e) {
			this.handlers[e] && (this.handlers[e] = null)
		}, n.prototype.forEach = function(e) {
			o.forEach(this.handlers, function(t) {
				null !== t && e(t)
			})
		}, e.exports = n
	}, function(e, t) {
		"use strict";
		e.exports = function(e) {
			return /^([a-z][a-z\d\+\-\.]*:)?\/\//i.test(e)
		}
	}, function(e, t) {
		"use strict";
		e.exports = function(e, t) {
			return e.replace(/\/+$/, "") + "/" + t.replace(/^\/+/, "")
		}
	}, function(e, t) {
		"use strict";
		e.exports = function(e, t) {
			return function() {
				for (var r = new Array(arguments.length), n = 0; n < r.length; n++) r[n] = arguments[n];
				return e.apply(t, r)
			}
		}
	}, function(e, t) {
		"use strict";
		e.exports = function(e) {
			return function(t) {
				return e.apply(null, t)
			}
		}
	}])
});
//# sourceMappingURL=axios.min.map
