from collections import defaultdict

class Solution:
    def subdomainVisits(self, cpdomains):
        """
        :type cpdomains: List[str]
        :rtype: List[str]
        """
        count = defaultdict(int)
        for domains in cpdomains:
            visit, domain = domains.split()
            tmp = domain.split('.')
            for i in range(len(tmp)):
                count['.'.join(tmp[i:])] += int(visit)

        return ["%d %s" % (count[key], key) for key in count]
